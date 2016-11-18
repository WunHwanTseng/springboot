package org.cn.blog.controller.blog.utils;

import org.cn.blog.utils.EqualsUtils;
import org.cn.blog.utils.code.Captcha;
import org.cn.blog.utils.code.GifCaptcha;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by WunHwanTseng on 2016/10/30.
 */
@Controller
public class UtilsController {

    @GetMapping("/blog/code")
    public void code(HttpServletResponse response, HttpSession session) {
        Captcha captcha = new GifCaptcha(110, 33, 4);
        try {
            captcha.out(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        session.setAttribute("code", captcha.text().toLowerCase());
    }

    @GetMapping("/checkCode")
    public void checkCode(@RequestParam("code") String code, HttpSession session, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        String checkcode = (String) session.getAttribute("code");
        boolean b = EqualsUtils.equals(checkcode, code);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(b);
    }

    @GetMapping("/message")
    public String message(){
        return "message";
    }

    @GetMapping("/blog/checkUser")
    public void checkUser(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            if (username == null) {
                printWriter.print(false);
            } else {
                printWriter.print(true);
            }
        } else {
            String username = principal.toString();
        }
    }

}
