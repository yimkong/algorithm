package hotswap;

import java.lang.instrument.Instrumentation;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 * author yg
 * description
 * 可以通过maven打包把虚拟机启动参数写在MENIFEST.MF文件里
 * Manifest-Version: 1.0
 * Premain-Class: 代理类的完整类路径
 * Built-By: yimkong
 * Agent-Class: 代理类的完整类路径
 * Can-Redefine-Classes: true
 * Can-Retransform-Classes: true
 * Created-By: Apache Maven 3.3.9
 * Build-Jdk: 1.8.0_152
 * <p>
 * 也可以通过启动类的时候添加vm参数 -javaagent:F:/algorithm/target/algorithm-1.0-SNAPSHOT.jar="classPath=:F:/algorithm/class,interval=1000,logLevel=FINE"
 * <p>
 * date 2019/12/4
 */
public class Agent {
    private static final Logger log = Logger.getLogger(Agent.class.getName());

    private static Instrumentation instrumentation;
    private static String classPath;

    public Agent() {
    }

    public static void premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
        initArgs(agentArgs);
    }

    private static void initArgs(String agentArgs) {
        AgentArgs args = new AgentArgs(agentArgs);
        if (!args.isValid()) {
            throw new RuntimeException("args is invalid");
        } else {
            init(args);
        }
    }

    private static void init(AgentArgs args) {
        classPath = args.getClassPath();
        int scanInterval = 500;
        if (args.getInterval() > scanInterval) {
            scanInterval = args.getInterval();
        }

        log.setUseParentHandlers(false);
        log.setLevel(args.getLogLevel());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(args.getLogLevel());
        log.addHandler(consoleHandler);
        HotSwapMonitor monitor = new HotSwapMonitor(instrumentation, classPath, args.getInterval(), args.getLogLevel(), consoleHandler);
        monitor.start();
        log.info("class path: " + classPath);
        log.info("scan interval (ms): " + scanInterval);
        log.info("log level: " + log.getLevel());
    }

    public static synchronized void agentmain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static Instrumentation getInstrumentation() {
        return instrumentation;
    }
}
