package org.cn.blog.mapper;

import org.cn.blog.entity.PowerFile;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/7.
 */
@Mapper
public interface PowerFileMapper {

    @Insert("INSERT INTO powerfile(id, name, path, `dec`, uploadtime) VALUES (#{id}, #{name}, #{path}, #{dec}, #{uploadtime})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insert(PowerFile powerFile);

    @Select("SELECT count(*) FROM powerfile WHERE name = #{name}")
    int selectCountPowerFileName(@Param("name") String name);

    @Select("SELECT * FROM powerfile GROUP BY uploadtime")
    List<PowerFile> selectPowerFile();

}
