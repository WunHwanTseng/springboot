package org.cn.blog.controller.manage.article;

import org.cn.blog.entity.Article;
import org.cn.blog.entity.Articletype;
import org.cn.blog.service.ArticleService;
import org.cn.blog.service.ArticleTypeService;
import org.cn.blog.utils.LoggerUtils;
import org.cn.blog.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
@Controller
@PreAuthorize("hasRole('admin')")
public class PublishController {
    @Autowired
    private ArticleTypeService articleTypeService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/article/publish")
    public ModelAndView publishArticle(@RequestParam("type") String type, Article article) {
        ModelAndView modelAndView = new ModelAndView();
        if (StringUtils.isNotBrank(article.getTitle()) && StringUtils.isNotBrank(article.getContent()) && StringUtils.isNotBrank(article.getKeyword()) && StringUtils.isNotBrank(type)) {
            int count = articleService.insert(article);
            Articletype articletype = articleTypeService.selectArticleTypeName(type);
            int typeCount = articleService.insertArticleType(count, articletype.getId());
            if (typeCount < 0) {
                LoggerUtils.debug(Articletype.class, "插入的id异常");
            }
            modelAndView.addObject("title", "成功");
            modelAndView.addObject("context", "文章发布成功");
            modelAndView.setViewName("redirect:/articleManage");
        } else {
            modelAndView.addObject("title", "ERROR");
            modelAndView.addObject("context", "抱歉，在文章发布出错了，请重新发布！");
            modelAndView.setViewName("/message");
        }
        return modelAndView;
    }
}
