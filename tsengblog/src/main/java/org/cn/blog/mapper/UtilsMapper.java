package org.cn.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by WunHwanTseng on 2016/11/5.
 */
@Mapper
public interface UtilsMapper {

    @Select("SELECT last_insert_id()")
    int selectLastInsertId();

}
