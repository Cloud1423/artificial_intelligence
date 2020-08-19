package com.xtm.service;


import com.xtm.dao.CommonRepositoty;
import com.xtm.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentsService {

    @Autowired
    private CommonRepositoty commonRepositoty;

    public List<Object> findCommentByArticleId(int id){
        return commonRepositoty.findCommentByArticleId(id);
    }

    public void addComment(Comments comment){
        commonRepositoty.addComment(comment);
    }

    public void addToNewUser(int authorId){
        commonRepositoty.addToNewUser(authorId);
    }

    public void deleteComment(int commentId){
        commonRepositoty.deletecomment(commentId);
    }
}
