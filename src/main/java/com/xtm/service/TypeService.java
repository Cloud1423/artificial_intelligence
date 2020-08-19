package com.xtm.service;


import com.xtm.dao.TypeRepositoty;
import com.xtm.model.ArticleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeService {

    @Autowired
    private TypeRepositoty typeRepositoty;

    public List<ArticleType> findAllType(){
        return typeRepositoty.findAllType();
    }

    public void addType(String typeName,int userId){
        ArticleType articleType = new ArticleType();
        articleType.setClassification(typeName);
        articleType.setUserId(userId);
        typeRepositoty.addType(articleType);
    }

    public void deleteType(String TypeName){
        typeRepositoty.deleteType(TypeName);
    }
}
