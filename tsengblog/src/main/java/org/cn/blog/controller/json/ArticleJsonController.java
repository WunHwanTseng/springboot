package org.cn.blog.controller.json;

import org.cn.blog.entity.Article;
import org.cn.blog.pagehepler.PageBean;
import org.cn.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/3.
 */
@RestController
public class ArticleJsonController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/articleNewList")
    public List<Article> articleNewList() {
        List<Article> list = articleService.selectNewArticleListLimit();
        return list;
    }

    @GetMapping("/articleManage/articlePageBean")
    @PreAuthorize("hasRole('admin')")
    public PageBean articlePageBean(int pageNum, int pageSize) {
        PageBean<Article> pageBean = this.articleService.selectArticleList(pageNum, pageSize);
        return pageBean;
    }

    @GetMapping("/article/articleHotList")
    public List<Article> articleHotList(){
        List<Article> list = articleService.selectHotArticleListLimit();
        return list;
    }

    @GetMapping("/articleManage/delete")
    @PreAuthorize("hasRole('admin')")
    public boolean articleManageDelete(@RequestParam("id") int id) {
        boolean b = articleService.deleteById(id);
        return b;
    }

}
