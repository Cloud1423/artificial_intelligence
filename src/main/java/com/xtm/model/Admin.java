package com.xtm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:藏剑
 * @date:2019/6/18 10:45
 * 管理员实体类
 */
@Entity                     //当实体类名和表名相同，实体属性和表字段相同时，会默认完成实体属性和表字段的映射
@Table(name = "admin")      //name 用来命名 当前实体类 对应的数据库 表的名字
public class Admin {

    @Id//主键字段
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer id;//用户id

    @Column(length = 15)
    private String account;//登录名称

    @Column(length = 10)
    private String adminName;//管理员名字

    @Column(length = 15)
    private String password;//管理员密码

    @Column(length = 100)
    private String headUrl;//头像路径

    @Column(length = 100)
    private String profile;//个性说明


    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", profile='" + profile + '\'' +

                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


}
