package org.cn.blog.service.impl;

import org.cn.blog.entity.Article;
import org.cn.blog.exception.ServiceException;
import org.cn.blog.mapper.ArticleMapper;
import org.cn.blog.pagehepler.PageBean;
import org.cn.blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public int insert(Article article) {
        article.setPublishtime(new Date());
        article.setPvvv(0);
        article.setRecommend(false);
        articleMapper.insert(article);
        return this.articleMapper.selectMaxId();
    }

    public int insertArticleType(int articleid, int typeid) {
        return this.articleMapper.insertArticleType(articleid, typeid);
    }

    public int selectMaxId() {
        return this.articleMapper.selectMaxId();
    }

    public List<Article> selectNewArticleListLimit() {
        return this.articleMapper.selectNewArticleListLimit();
    }

    public PageBean<Article> selectNewArticleList(int pageNum, int pageSize) {
        if (pageNum <= 0 && pageSize <= 0) {
            throw new ServiceException("UserArticleReply selectUserArticleReply error");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = this.articleMapper.selectNewArticleList();
        return new PageBean<>(list);
    }

    public List<Article> selectHotArticleListLimit() {
        return this.articleMapper.selectHotArticleListLimit();
    }

    public PageBean<Article> selectHotArticleList(int pageNum, int pageSize) {
        if (pageNum <= 0 && pageSize <= 0) {
            throw new ServiceException("UserArticleReply selectUserArticleReply error");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = this.articleMapper.selectHotArticleList();
        return new PageBean<>(list);
    }

    @Cacheable(value = "article")
    public Article selectArticleById(Integer id) {
        return this.articleMapper.selectArticleById(id);
    }

    public void updateArticlePvvv(Article article) {
        article.setPvvv(article.getPvvv() + 1);
        this.articleMapper.updateArticlePvvv(article);
    }

    public PageBean<Article> selectArticleList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = this.articleMapper.selectArticleList();
        return new PageBean<>(list);
    }

    public void updateRecommend(Integer id) {
        Article article = this.articleMapper.selectArticleById(id);
        if (article.isRecommend()) {
            article.setRecommend(false);
        } else {
            article.setRecommend(true);
        }
    }

    public boolean deleteById(int id) {
        boolean b = false;
        this.articleMapper.deleteById(id);
        Article article = this.articleMapper.selectArticleById(id);
        if (article == null) {
            b = true;
        }
        return b;
    }
}
