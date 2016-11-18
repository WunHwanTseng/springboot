package org.cn.blog.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by WunHwanTseng on 2016/11/1.
 */
/**
 * 文章
 */
public class Article implements Serializable {
    private static final long serialVersionUID = 3455659145953003146L;
    private Integer id; //主键
    private String title; // 文章标题
    private String content; //文章内容
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    private Date publishtime; //发表时间
    private int pvvv; // 访问量
    private String keyword; // 关键词
    private boolean recommend; //是否推荐

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public int getPvvv() {
        return pvvv;
    }

    public void setPvvv(int pvvv) {
        this.pvvv = pvvv;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishtime=" + publishtime +
                ", pvvv=" + pvvv +
                ", keyword='" + keyword + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
