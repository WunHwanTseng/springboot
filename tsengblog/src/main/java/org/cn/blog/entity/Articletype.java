package org.cn.blog.entity;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */

import java.io.Serializable;

/**
 * 文章类型
 */
public class Articletype implements Serializable {
    private static final long serialVersionUID = -6778942941742895970L;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Articletype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
