package hotswap;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author yg
 * description
 * date 2019/12/4
 */
public class HotSwapMonitor implements Runnable {
    private String classPath;
    private Instrumentation instrumentation;
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private int interval;
    private static final Logger logger = Logger.getLogger(HotSwapMonitor.class.getName());

    public HotSwapMonitor(Instrumentation instrumentation, String classPath, int interval, Level logLevel, ConsoleHandler consoleHandler) {
        this.instrumentation = instrumentation;
        this.classPath = classPath;
        this.interval = interval;
        logger.setLevel(logLevel);
        logger.addHandler(consoleHandler);
    }

    public void start() {
        this.executor.scheduleAtFixedRate(this, interval, (long) this.interval, TimeUnit.MILLISECONDS);
    }

    public void run() {
        try {
            this.scanClassFile();
        } catch (Exception var2) {
            logger.log(Level.SEVERE, "error", var2);
        }

    }

    public void scanClassFile() throws Exception {
        File path = new File(this.classPath);
        File[] files = path.listFiles();
        if (files != null) {
            String classFilePath;
            boolean success = false;
            long now = System.currentTimeMillis();
            File[] var7 = files;
            int var8 = files.length;

            for (int var9 = 0; var9 < var8; ++var9) {
                File file = var7[var9];
                if (this.isClassFile(file)) {
                    classFilePath = file.getPath();
                    this.reloadClass(classFilePath);
                    logger.fine(String.format("Reload %s success", classFilePath));
//                    file.delete();
                    success = true;
                }
            }

            if (success) {
                logger.fine(String.format("Reload success, cost time:%sms", System.currentTimeMillis() - now));
            }

        }
    }

    private void reloadClass(String classFilePath) throws Exception {
        File file = new File(classFilePath);
        byte[] buff = new byte[(int) file.length()];
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        in.readFully(buff);
        in.close();
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class<?> updateCalss = loader.findClass(buff);
        Class<?> theClass = Class.forName(updateCalss.getName());
        ClassDefinition definition = new ClassDefinition(theClass, buff);
        this.instrumentation.redefineClasses(definition);
    }

    private boolean isClassFile(File file) {
        return file.getName().contains(".class");
    }
}
