package org.cn.blog.utils.code;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WunHwanTseng on 2016/11/8.
 */
public class TimeUtls {

    public static String timeFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/HH/mm");
        String time = simpleDateFormat.format(date);
        return time;
    }

}
