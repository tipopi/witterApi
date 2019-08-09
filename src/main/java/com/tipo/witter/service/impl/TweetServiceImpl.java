package com.tipo.witter.service.impl;

import com.tipo.witter.mapper.TweetMapper;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20199:47 AM
 */
@Service
public class TweetServiceImpl implements TweetService {
    @Autowired
    private TweetMapper mapper;
    @Override
    public Msg addTweet(Integer userId, String text) {
        if (mapper.addTweet(userId,text)==1){
            return Msg.success();
        }
        return Msg.fail();
    }
}
