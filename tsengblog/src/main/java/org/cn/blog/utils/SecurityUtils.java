package org.cn.blog.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by WunHwanTseng on 2016/11/5.
 */
public class SecurityUtils {

    public static String getPrincipalUsername(){
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = null;
        }
        return username;
    }

}
