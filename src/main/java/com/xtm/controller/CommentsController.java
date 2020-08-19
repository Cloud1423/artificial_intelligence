package com.xtm.controller;

import com.xtm.model.Comments;
import com.xtm.service.CommentsService;
import com.xtm.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class CommentsController {

    @Autowired
    private CommentsService commentsService;


    @ResponseBody//这个注解很重要
    @GetMapping("/comment/{articleId}")
    public  Map<String, Object> findCommentByArticleId(@PathVariable("articleId") Integer articleId){

        Map<String, Object> result = new HashMap<String, Object>();
        List<Object> comments = commentsService.findCommentByArticleId(articleId);
        List<Comments> commentResult = new ArrayList<>();
        //查找和文章有关的所有评论
        for (Object o : comments){
            Object[] rowArray = (Object[]) o;
            Comments CWA = new Comments();
            CWA.setCommonId((Integer) rowArray[0]);
            CWA.setCommonContent((String) rowArray[1]);
            CWA.setArticleId((Integer) rowArray[2]);
            CWA.setHeadUrl((String) rowArray[3]);
            CWA.setReviewerName((String)rowArray[4]);
            commentResult.add(CWA);
        }
        result.put("count", commentResult.size());
        result.put("data", commentResult);
        result.put("code", 0);
        result.put("msg", "");
        //newsService.clickArticleById(articleId);
        return result;
    }

    /*
     *
     * 存储评论
     * */
    @ResponseBody
    @GetMapping("/comment")
    public void saveComment(HttpServletRequest request){
        String content = request.getParameter("content");
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        String headUrl = request.getParameter("headUrl");
        String reviewerName = request.getParameter("reviewerName");
        Comments comment = new Comments();
        comment.setCommonContent(content);
        comment.setArticleId(articleId);
        comment.setReviewerName(reviewerName);
        comment.setHeadUrl(headUrl);
        commentsService.addComment(comment);
    }

    /*
    * 删除某个评论
    * */
    @DeleteMapping("/comment/delete/{id}")
    @ResponseBody
    public void deleteNews(@PathVariable("id") Integer id) {
        log.info("要删除的评论id:" + id);
        commentsService.deleteComment(id);
        //return "{\"msg\": \"删除成功\"}";
    }

}
