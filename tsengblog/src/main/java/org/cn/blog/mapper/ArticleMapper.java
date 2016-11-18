package org.cn.blog.mapper;

import org.apache.ibatis.annotations.*;
import org.cn.blog.entity.Article;

import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO article(id, title, content, publishtime, pvvv, keyword, recommend) VALUES (#{id}, #{title}, #{content}, #{publishtime}, #{pvvv}, #{keyword}, #{recommend})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(Article article);

    @Insert("INSERT INTO article_type(articleid, typeid) VALUES(#{articleid}, #{typeid}) ")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertArticleType(@Param("articleid") int articleid, @Param("typeid") int typeid);

    @Select("SELECT max(id) FROM article")
    int selectMaxId();

    @Select("SELECT id, title, publishtime FROM article GROUP BY publishtime LIMIT 5")
    List<Article> selectNewArticleListLimit();

    @Select("SELECT id, title, publishtime FROM article GROUP BY pvvv DESC LIMIT 5")
    List<Article> selectHotArticleListLimit();

    @Select("SELECT id, title, pvvv, publishtime FROM article GROUP BY publishtime")
    List<Article> selectNewArticleList();

    @Select("SELECT id, title, pvvv, publishtime FROM article GROUP BY pvvv DESC")
    List<Article> selectHotArticleList();

    @Select("SELECT * FROM article GROUP BY publishtime")
    List<Article> selectArticleList();

    @Delete("DELETE FROM article WHERE id = #{id}")
    void deleteById(int id);

    @Update("UPDATE article SET recommend = #{recommend} WHERE id = #{id}")
    void updateRecommend(Article article);

    @Select("SELECT * FROM article WHERE id = #{id}")
    Article selectArticleById(@Param("id") Integer id);

    @Update("UPDATE article SET pvvv = #{pvvv} WHERE id = #{id}")
    void updateArticlePvvv(Article article);

}
