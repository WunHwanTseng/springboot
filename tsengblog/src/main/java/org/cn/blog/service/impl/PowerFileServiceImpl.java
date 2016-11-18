package org.cn.blog.service.impl;

import org.cn.blog.entity.PowerFile;
import org.cn.blog.exception.ServiceException;
import org.cn.blog.mapper.PowerFileMapper;
import org.cn.blog.pagehepler.PageBean;
import org.cn.blog.service.PowerFileService;
import org.cn.blog.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by WunHwanTseng on 2016/11/7.
 */
@Service
public class PowerFileServiceImpl implements PowerFileService {
    @Autowired
    private PowerFileMapper powerFileMapper;

    public int insert(PowerFile powerFile) {
        powerFile.setUploadtime(new Date());
        System.out.println(powerFile);
        return this.powerFileMapper.insert(powerFile);
    }

    @Cacheable(value = "fileCountName")
    public int selectCountPowerFileName(String name) {
        if (StringUtils.isBrank(name)) {
            throw new ServiceException("File Name Error");
        }
        return this.powerFileMapper.selectCountPowerFileName(name);
    }

    public PageBean<PowerFile> selectPowerFilePageBean(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PowerFile> list = this.powerFileMapper.selectPowerFile();
        return new PageBean<>(list);
    }
}
