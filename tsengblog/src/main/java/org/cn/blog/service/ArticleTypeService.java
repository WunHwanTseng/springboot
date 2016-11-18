package org.cn.blog.service;

import org.cn.blog.pagehepler.PageBean;
import org.cn.blog.entity.Articletype;

import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
public interface ArticleTypeService {

    int insert(Articletype articletype);

    PageBean<Articletype> selectArticletypePageList(int pageNum, int pageSize);

    int selectArticleTypeCount(String name);

    Articletype selectArticleTypeName(String type);

    List<Articletype> selectArticletypeList();

    Articletype selectArticleTypeById(Integer id);

    void updateById(Articletype articletype);

    void deleteById(Integer id);

}
