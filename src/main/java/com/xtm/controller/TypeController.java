package com.xtm.controller;

import com.xtm.dao.TypeRepositoty;
import com.xtm.model.Admin;
import com.xtm.model.ArticleType;
import com.xtm.model.NewsAuthor;
import com.xtm.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;


    @GetMapping("/type/findAll")
    public Map<String, Object> findAll(){

        Map<String, Object> result = new HashMap<String, Object>();
        //查找所有文章
        ArrayList<ArticleType> types = (ArrayList<ArticleType>) typeService.findAllType();
//        List<ArticleType> views = new ArrayList<ArticleType>();
//        for(ArticleType view:types){
//            //ArticleType temp = new ArticleType();
//            views.add(view);
//        }
//        List<NewsAuthor> voidiews = new ArrayList<NewsAuthor>();
        result.put("data", types);
        result.put("code", 0);
        result.put("msg", "");
        log.info(result.toString());
        return result;
    }


    @PutMapping("/types/add")
    @ResponseBody
    public String addType(String name,HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        typeService.addType(name,admin.getId());
        return "success";
    }

    @GetMapping("/type/deleteOne/{name}")
    public void deleteOne(@PathVariable("name") String name){
        typeService.deleteType(name);
    }
}
