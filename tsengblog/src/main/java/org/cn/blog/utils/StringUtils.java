package org.cn.blog.utils;

/**
 * Created by WunHwanTseng on 2016/10/30.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 一次性判断多个或着单个对象为空
     * @param objects
     * @return
     */
    public static boolean isBlank(Object...objects) {
        Boolean result = false;
        for (Object object : objects) {
            if (null == object || "".equals(object.toString().trim()) || "null".equals(object.toString().trim())) {
                result=true;
                break;
            }
        }
        return result;
    }

    public static boolean isNotBrank(Object... objects) {
        return !isBlank(objects);
    }
    public static boolean isBrank(String... objects) {
        Object[] object = objects;
        return isBlank(object);
    }
    public static boolean isNotBrank(String... objects) {
        Object[] object = objects;
        return !isBlank(object);
    }
    public static boolean isBrank(String str) {
        Object object = str;
        return isBlank(object);
    }
    public static boolean isNotBrank(String str) {
        Object object = str;
        return !isBlank(object);
    }

    public static int indexOf(String baseStr,String[] strings) {
        if (null == baseStr || baseStr.length() == 0 || null == strings)
            return 0;
        int i = 0;
        for (String string : strings) {
            boolean result=baseStr.equals(string);
            i = result ? ++i : i;
        }
        return i;
    }

}
