package com.xtm.dao;


import com.xtm.model.ArticleType;
import com.xtm.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CommonRepositoty extends JpaRepository<ArticleType, String> {

    /*
    * 查询某篇文章的评论
    * */
    @Query(value = "select * from common where article_id=?1", nativeQuery = true)
    List<Object> findCommentByArticleId(int id);

    /*
    * 给某篇文章添加评论
    * */
    @Modifying
    @Query(value = "insert into common(common_content, article_id,head_url,reviewer_name) VALUES (:#{#comment.commonContent},:#{#comment.articleId},:#{#comment.headUrl},:#{#comment.reviewerName})",nativeQuery = true)
    void addComment(Comments comment);

    /*
    * 给中间表添加信息
    * */
    @Modifying
    @Query(value = "UPDATE comments_author SET author_id = ? WHERE author_id IS NULL;",nativeQuery = true)
    void addToNewUser(int userId);


    /*
    * 删除某个评论
    * */
    @Modifying
    @Query(value = "DELETE FROM common WHERE common_id = ?1 ",nativeQuery = true)
    void deletecomment(int id);
}
