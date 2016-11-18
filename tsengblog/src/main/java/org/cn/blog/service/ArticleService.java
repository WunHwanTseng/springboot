package org.cn.blog.service;

import org.cn.blog.entity.Article;
import org.cn.blog.pagehepler.PageBean;

import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
public interface ArticleService {

    int insert(Article article);

    int insertArticleType(int articleid, int typeid);

    int selectMaxId();

    List<Article> selectNewArticleListLimit();

    PageBean<Article> selectNewArticleList(int pageNum, int pageSize);

    List<Article> selectHotArticleListLimit();

    PageBean<Article> selectHotArticleList(int pageNum, int pageSize);

    PageBean<Article> selectArticleList(int pageNum, int pageSize);

    Article selectArticleById(Integer id);

    boolean deleteById(int id);

    void updateRecommend(Integer id);

    void updateArticlePvvv(Article article);

}
