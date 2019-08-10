package com.tipo.witter.service;

import com.tipo.witter.pojo.CommentIn;
import com.tipo.witter.pojo.Msg;
/**
 * @author Tipo
 * @version 1.0
 * @date 8/10/20198:25 AM
 */
public interface CommentService {
    Msg addComment(CommentIn in);
    Msg findComment(Integer href,Integer type);
    Msg deleteComment(Integer cmId);
}
