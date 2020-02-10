package com.tipo.witter.service;

import com.tipo.witter.pojo.BlogIn;
import com.tipo.witter.pojo.BlogUp;
import com.tipo.witter.pojo.Msg;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/3 14:44
 */
public interface BlogService {
    Msg findList(Long time,Integer size,Integer page,String tagId);
    Msg getContent(Integer blogId);
    Msg addBlog(BlogIn in);
    Msg updateBlog(BlogUp up);
}
