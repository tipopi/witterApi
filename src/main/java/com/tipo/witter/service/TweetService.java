package com.tipo.witter.service;

import com.tipo.witter.pojo.Msg;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20199:41 AM
 */
public interface TweetService {
    Msg addTweet(Integer userId,String text);


}
