package org.cn.blog.controller.blog.article;

import org.cn.blog.entity.Article;
import org.cn.blog.pagehepler.PageBean;
import org.cn.blog.service.ArticleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by WunHwanTseng on 2016/11/7.
 */
@Controller
public class ArticleListController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/ArticleNewList")
    public String articleNewList(){
        return "/articleNewList";
    }

    @GetMapping("/articleList/newListJson")
    public void articleNewListJson(int pageNum, int pageSize, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        PageBean<Article> pageBean = articleService.selectNewArticleList(pageNum, pageSize);
        String json = JSON.toJSONString(pageBean);
        printWriter.print(json);
    }

    @GetMapping("/articleList/hotListJson")
    public void articleHotListJson(int pageNum, int pageSize, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        PageBean<Article> pageBean = articleService.selectHotArticleList(pageNum, pageSize);
        String json = JSON.toJSONString(pageBean);
        printWriter.print(json);
    }

}
