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
    /**
     * 方案使用伪删除，之后加入批量真删的，没有其他依赖
     * @date 10:29 AM 8/22/2019
     * @return com.tipo.witter.pojo.Msg
     **/
    Msg deleteComment(Integer cmId);
}
