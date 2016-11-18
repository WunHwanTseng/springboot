package org.cn.blog.mapper;

import org.cn.blog.entity.Articletype;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
@Mapper
public interface ArticleTypeMapper {

    @Insert("INSERT INTO articletype(name) VALUES(#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insert(Articletype articletype);

    @Select("SELECT id,name FROM articletype WHERE name=#{type}")
    Articletype selectArticleTypeName(@Param("type") String type);

    @Select("SELECT * FROM articletype GROUP BY id")
    List<Articletype> selectArticletypeList();

    @Select("SELECT count(name) FROM articletype WHERE name = #{name}")
    int selectArticleTypeCount(@Param("name") String name);

    @Delete("DELETE FROM articletype WHERE id = #{id}")
    void deleteById(@Param("id") Integer id);

    @Select("SELECT * FROM articletype WHERE id = #{id}")
    Articletype selectArticleTypeById(@Param("id") Integer id);

    @Update("UPDATE articletype SET name = #{name} WHERE id = #{id}")
    void updateById(Articletype articletype);
}
