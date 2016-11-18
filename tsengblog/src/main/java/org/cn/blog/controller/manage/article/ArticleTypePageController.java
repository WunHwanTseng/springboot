package org.cn.blog.controller.manage.article;

import org.cn.blog.pagehepler.PageBean;
import org.cn.blog.entity.Articletype;
import org.cn.blog.service.ArticleTypeService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by WunHwanTseng on 2016/11/2.
 */
@Controller
@PreAuthorize("hasRole('admin')")
public class ArticleTypePageController {
    @Autowired
    private ArticleTypeService articleTypeService;

    @GetMapping("/articletype/articletypePage")
    public void articletypePageBeanList(int pageNum, int pageSize, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PageBean<Articletype> pageBean = articleTypeService.selectArticletypePageList(pageNum, pageSize);
        String json = JSONArray.toJSONString(pageBean);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(json);
    }

}
