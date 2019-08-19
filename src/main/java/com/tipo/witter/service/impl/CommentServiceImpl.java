package com.tipo.witter.service.impl;

import com.tipo.witter.mapper.CommentMapper;
import com.tipo.witter.pojo.CommentIn;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author Tipo
 * @version 1.0
 * @date 8/10/20198:25 AM
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper mapper;
    @Override
    public Msg addComment(CommentIn in) {
        Integer id = mapper.addComment(in);
        if (id != null){
            return Msg.success(id);
        }
        return Msg.fail();
    }

    @Override
    public Msg findComment(Integer href, Integer type) {
        return Msg.success(mapper.findComment(href,type));
    }

    @Override
    public Msg deleteComment(Integer cmId) {
        if (mapper.deleteComment(cmId)==1){
            return Msg.success();
        }
        return Msg.fail();
    }
}
