package org.cn.blog.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by WunHwanTseng on 2016/11/7.
 */
public class PowerFile implements Serializable {
    private static final long serialVersionUID = 8509289914381677336L;
    private int id;
    private String name;
    private String path;
    private String dec;
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    private Date uploadtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    @Override
    public String toString() {
        return "PowerFile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dec='" + dec + '\'' +
                ", uploadtime=" + uploadtime +
                '}';
    }
}
