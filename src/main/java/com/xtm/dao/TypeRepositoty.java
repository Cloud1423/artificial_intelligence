package com.xtm.dao;


import com.xtm.model.ArticleType;
import com.xtm.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TypeRepositoty  extends JpaRepository<ArticleType, String> {

    /*
    * 查询所有文章分类
    * */
    @Query(value = "select * from classification_table", nativeQuery = true)
    List<ArticleType> findAllType();

    /*
    * 添加文章分类
    * */
    @Modifying
    @Query(value = "insert into classification_table(classification, user_id) VALUES (:#{#articleType.classification},:#{#articleType.userId})",nativeQuery = true)
    void addType(ArticleType articleType);

    /*
    * 删除文章分类
    * */
    @Modifying
    @Query(value = "DELETE FROM classification_table WHERE classification = ?1 ",nativeQuery = true)
    void deleteType(String name);
}
