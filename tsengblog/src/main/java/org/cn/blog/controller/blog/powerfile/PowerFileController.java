package org.cn.blog.controller.blog.powerfile;

import org.cn.blog.entity.PowerFile;
import org.cn.blog.pagehepler.PageBean;
import org.cn.blog.service.PowerFileService;
import org.cn.blog.utils.FileUtils;
import org.cn.blog.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by WunHwanTseng on 2016/11/7.
 */
@Controller
@Scope("prototype")
public class PowerFileController {
    @Autowired
    private PowerFileService powerFileService;

    @GetMapping("/filePublish/checkName")
    public void selectCountName(@Param("name") String name, HttpServletResponse response) throws IOException {
        boolean b = false;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        if (StringUtils.isNotBrank(name)) {
            int count = powerFileService.selectCountPowerFileName(name);
            if (count == 0) {
                b = true;
            }
        }
        printWriter.print(b);
    }

    @GetMapping("/filePublish")
    public String powerFilePublish(){
        return "/filepublish";
    }

    @GetMapping("/fileList")
    public String fileList() {
        return "/fileList";
    }

    @GetMapping("/file/ajaxList")
    public void fileList(int pageNum, int pageSize, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        PageBean<PowerFile> pageBean = powerFileService.selectPowerFilePageBean(pageNum, pageSize);
        String json = JSON.toJSONString(pageBean);
        printWriter.print(json);
    }

    @PostMapping("/filePublish/fileAjaxUpload")
    public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, PowerFile powerFile) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/fileList");
        System.out.println(file.getOriginalFilename());
        powerFile.setPath(file.getOriginalFilename());
        powerFileService.insert(powerFile);
        FileUtils.upload(file, file.getOriginalFilename());
        return modelAndView;
    }

}
