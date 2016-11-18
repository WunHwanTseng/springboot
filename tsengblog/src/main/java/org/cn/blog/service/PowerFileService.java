package org.cn.blog.service;

import org.cn.blog.entity.PowerFile;
import org.cn.blog.pagehepler.PageBean;

import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/7.
 */
public interface PowerFileService {

    int insert(PowerFile powerFile);

    int selectCountPowerFileName(String name);

    PageBean<PowerFile> selectPowerFilePageBean(int pageNum, int pageSize);

}
