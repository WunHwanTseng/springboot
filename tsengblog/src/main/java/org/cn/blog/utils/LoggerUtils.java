package org.cn.blog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by WunHwanTseng on 2016/10/30.
 */
public class LoggerUtils {
    private static boolean isDebug = LoggerFactory.getLogger(LoggerUtils.class).isDebugEnabled();

    /**
     * Debug输出信息
     * @param clazz 目标class
     * @param message 输出信息
     */
    public static void debug(Class<? extends Object> clazz, String message) {
        if (!isDebug)
            return;
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.debug(message);
    }

    public static void debug(Class<? extends Object> clazz, String fmtString, Object... value) {
        if (!isDebug)
            return;
        if (null != value && value.length != 0) {
            fmtString = String.format(fmtString, value);
        }
        debug(clazz,fmtString);
    }

    /**
     * Error 输出
     * @param clazz 目标class
     * @param message 输出信息
     * @param e 异常类
     */
    public static void error(Class<? extends Object> clazz, String message, Exception e) {
        Logger logger = LoggerFactory.getLogger(clazz);
        if (null == e) {
            logger.error(message);
            return;
        }
        logger.error(message, e);
    }

    /**
     * Error 输出
     * @param clazz 目标class
     * @param message 输出信息
     */
    public static void error(Class<? extends Object> clazz, String message) {
        error(clazz, message, null);
    }

}
