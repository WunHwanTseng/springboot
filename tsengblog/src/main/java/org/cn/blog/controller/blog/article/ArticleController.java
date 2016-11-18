package org.cn.blog.controller.blog.article;

import org.cn.blog.entity.Article;
import org.cn.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by WunHwanTseng on 2016/11/3.
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/Article")
    public ModelAndView ArticleIndex(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("/article");
        Article article = articleService.selectArticleById(id);
        articleService.updateArticlePvvv(article);
        modelAndView.addObject("article", article);
        modelAndView.addObject("articleid", id);
        return modelAndView;
    }

}
