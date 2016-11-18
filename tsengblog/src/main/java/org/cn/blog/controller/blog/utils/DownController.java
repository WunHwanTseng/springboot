package org.cn.blog.controller.blog.utils;

import org.cn.blog.service.PowerFileService;
import org.cn.blog.utils.PublicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by WunHwanTseng on 2016/11/9.
 */
@Controller
@Scope("prototype")
public class DownController {

    @GetMapping("/downFile")
    public void AjaxDownFIle(HttpServletResponse response, String path) throws IOException {
        File file = new File(PublicUtils.Public_Local_File + "/" + path);
        System.out.println(file.getPath());
        String filePath = PublicUtils.Public_Local_File + "/" + path;
        //设置响应类型
        response.setContentType("application/force-download");
        //读取文件
        InputStream in = new FileInputStream(filePath);
        response.setHeader("Content-Disposition", "attachment;filename=" + path);
        response.setContentLength(in.available());
        //开始文件copy
        OutputStream out = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        out.close();
        in.close();
    }

}
