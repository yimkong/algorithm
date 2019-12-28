package hotswap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * author yg
 * description
 * date 2019/12/4
 */
public class AgentArgs {
    private static final String CLASSES_PATH = "classPath";
    private static final String SCAN_INTERVAL = "interval";
    private static final String LOG_LEVEL = "logLevel";
    private String classPath;
    private int interval;
    private Level logLevel;

    private AgentArgs() {
        this.classPath = null;
        this.interval = -1;
        this.logLevel = Level.WARNING;
    }

    public AgentArgs(String agentArgs) {
        this();
        if (agentArgs != null && agentArgs.length() > 0 && agentArgs.indexOf("=") != -1) {
            this.initArgs(agentArgs);
        }

    }

    public String getClassPath() {
        return this.classPath;
    }

    public Level getLogLevel() {
        return this.logLevel;
    }

    public int getInterval() {
        return this.interval;
    }

    private void initArgs(String agentArgs) {
        String[] args = agentArgs.split(",");
        Map<String, String> argsMap = new HashMap();
        String[] var4 = args;
        int var5 = args.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String s = var4[var6];
            String[] param = s.split("=");
            argsMap.put(param[0].trim(), param[1]);
        }

        if (argsMap.containsKey("classPath")) {
            this.setClassPath((String)argsMap.get("classPath"));
        }

        if (argsMap.containsKey("interval")) {
            this.setInterval((String)argsMap.get("interval"));
        }

        if (argsMap.containsKey("logLevel")) {
            this.setLogLevel((String)argsMap.get("logLevel"));
        }

    }

    public boolean isValid() {
        return this.classPath != null;
    }

    private void setClassPath(String classPath) {
        this.classPath = parsePath(classPath);
    }

    private void setLogLevel(String logLevel) {
        try {
            this.logLevel = Level.parse(logLevel.trim());
        } catch (Exception var3) {
            this.logLevel = Level.WARNING;
        }

    }

    private void setInterval(String interval) {
        try {
            this.interval = Integer.parseInt(interval.trim());
        } catch (NumberFormatException var3) {
            this.interval = -1;
        }

    }

    private static String parsePath(String path) {
        if (path != null) {
            String result = path.trim();
            return result.endsWith(File.separator) ? result : result + File.separator;
        } else {
            return null;
        }
    }
}
