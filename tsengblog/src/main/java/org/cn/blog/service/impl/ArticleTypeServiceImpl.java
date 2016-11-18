package org.cn.blog.service.impl;

import org.cn.blog.pagehepler.PageBean;
import org.cn.blog.entity.Articletype;
import org.cn.blog.mapper.ArticleTypeMapper;
import org.cn.blog.service.ArticleTypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    public int insert(Articletype articletype) {
        return this.articleTypeMapper.insert(articletype);
    }

    public PageBean<Articletype> selectArticletypePageList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Articletype> list = this.articleTypeMapper.selectArticletypeList();
        return new PageBean<>(list);
    }

    public int selectArticleTypeCount(String name) {
        return this.articleTypeMapper.selectArticleTypeCount(name);
    }

    @Cacheable(value = "articleType")
    public Articletype selectArticleTypeName(String type) {
        return this.articleTypeMapper.selectArticleTypeName(type);
    }

    public List<Articletype> selectArticletypeList() {
        return this.articleTypeMapper.selectArticletypeList();
    }

    @Cacheable(value = "articleTypeId")
    public Articletype selectArticleTypeById(Integer id) {
        return this.articleTypeMapper.selectArticleTypeById(id);
    }

    public void updateById(Articletype articletype) {
        this.articleTypeMapper.updateById(articletype);
    }

    public void deleteById(Integer id) {
        this.articleTypeMapper.deleteById(id);
    }
}
