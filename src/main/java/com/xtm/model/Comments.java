package com.xtm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common")
public class Comments {

    @Id
    @Column(name = "common_id",length = 11)
    private int commonId;

    @Column(name = "common_content",length = 255)
    private String commonContent;

    @Column(name = "article_id",length = 11)
    private int articleId;

    @Column(name = "head_url",length = 255)
    private String headUrl;

    @Column(name = "reviewer_name",length = 255)
    private String reviewerName;


    public int getCommonId() {
        return commonId;
    }

    public void setCommonId(int commonId) {
        this.commonId = commonId;
    }

    public String getCommonContent() {
        return commonContent;
    }

    public void setCommonContent(String commonContent) {
        this.commonContent = commonContent;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
}
