package yxinfo.dct.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Log {

    public static void trace(String msg) {
        getLogger().trace(msg);
    }

    public static void trace(String format, Object arg) {
        getLogger().trace(format, arg);
    }

    public static void trace(String format, Object arg1, Object arg2) {
        getLogger().trace(format, arg1, arg2);
    }

    public static void trace(String format, Object... arguments) {
        getLogger().trace(format, arguments);
    }

    public static void trace(Throwable t, String format, Object... arguments) {
        getLogger().trace(format(format, arguments), t);
    }

    public static void debug(String msg) {
        getLogger().debug(msg);
    }

    public static void debug(String format, Object arg) {
        getLogger().debug(format, arg);
    }

    public static void debug(String format, Object arg1, Object arg2) {
        getLogger().debug(format, arg1, arg2);
    }

    public static void debug(String format, Object... arguments) {
        getLogger().debug(format, arguments);
    }

    public static void debug(Throwable t, String format, Object... arguments) {
        getLogger().debug(format(format, arguments), t);
    }

    public static void info(String msg) {
        getLogger().info(msg);
    }

    public static void info(String format, Object arg) {
        getLogger().info(format, arg);
    }

    public static void info(String format, Object arg1, Object arg2) {
        getLogger().info(format, arg1, arg2);
    }

    public static void info(String format, Object... arguments) {
        getLogger().info(format, arguments);
    }

    public static void info(Throwable t, String format, Object... arguments) {
        getLogger().info(format(format, arguments), t);
    }

    public static void warn(String msg) {
        getLogger().warn(msg);
    }

    public static void warn(String format, Object arg) {
        getLogger().warn(format, arg);
    }

    public static void warn(String format, Object arg1, Object arg2) {
        getLogger().warn(format, arg1, arg2);
    }

    public static void warn(String format, Object... arguments) {
        getLogger().warn(format, arguments);
    }

    public static void warn(Throwable t, String format, Object... arguments) {
        getLogger().warn(format(format, arguments), t);
    }

    public static void error(String msg) {
        getLogger().error(msg);
    }

    public static void error(String format, Object arg) {
        getLogger().error(format, arg);
    }

    public static void error(String format, Object arg1, Object arg2) {
        getLogger().error(format, arg1, arg2);
    }

    public static void error(String format, Object... arguments) {
        getLogger().error(format, arguments);
    }

    public static void error(Throwable t, String format, Object... arguments) {
        getLogger().error(format(format, arguments), t);
    }

    private static Map<String, Logger> map = new HashMap<String, Logger>();

    /**
     * 获取调用类名
     *
     * @return
     */
    private static String getCallerClassName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[4].getClassName();
    }

    /**
     * 获取logger
     *
     * @return
     */
    private static Logger getLogger() {
        String className = getCallerClassName();
        Logger log = map.get(className);
        if (log == null) {
            log = LoggerFactory.getLogger(className);
            map.put(className, log);
        }
        return log;
    }

    /**
     * 格式化文本
     *
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param values   参数值
     * @return 格式化后的文本
     */
    private static String format(String template, Object... values) {
        return String.format(template.replace("{}", "%s"), values);
    }
}
