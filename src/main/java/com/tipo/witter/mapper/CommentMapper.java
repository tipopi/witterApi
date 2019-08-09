package com.tipo.witter.mapper;

import com.tipo.witter.pojo.CommentIn;
import com.tipo.witter.pojo.CommentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20191:58 PM
 */
public interface CommentMapper {
    Integer addComment(CommentIn in);
    List<CommentResult> findComment(@Param("href") Integer href, @Param("type") Integer type);
    Integer deleteComment(Integer comId);
}
