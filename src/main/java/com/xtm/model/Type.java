package com.xtm.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classification_table")
public class Type {

    @Id
    @Column(name = "classification",length = 30)
    private String classification;
    @Column(name = "user_id",length = 11)
    private int userId;


    @Override
    public String toString() {
        return "Type{" +
                "classification='" + classification + '\'' +
                ", userId=" + userId +
                '}';
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
