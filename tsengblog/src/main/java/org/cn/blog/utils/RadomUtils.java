package org.cn.blog.utils;

import java.util.Random;

/**
 * Created by WunHwanTseng on 2016/10/31.
 */
public class RadomUtils {

    public static String code(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++)
                fourRandom = "0" + fourRandom  ;
        }
        return fourRandom;
    }

}
