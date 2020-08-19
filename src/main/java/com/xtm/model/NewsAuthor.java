package com.xtm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *
 */
public class NewsAuthor {

    /*
    * 文章对应id
    * */
    private Integer id;


    /*
    * 管理员昵称
    * */
    private String author;

    /*
    * 标题
    * */
    private String title;

    /*
    * 正文内容
    * */
    private String content;

    /*
    * 创建时间
    * */
    private Date createTime;

    /*
    * 作者id
    * */
    private Integer authorId;

    /*
    * 账号
    * */
    private String account;

    /*
    * 点击量
    * */
    private Integer click;

    /*
    * 文章类型
    * */
    private String type;

    @Override
    public String toString() {
        return "NewsAuthor{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", authorId=" + authorId +
                ", account='" + account + '\'' +
                ", click=" + click +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

}
