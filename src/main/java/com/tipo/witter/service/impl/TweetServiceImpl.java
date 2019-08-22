package com.tipo.witter.service.impl;

import com.tipo.witter.mapper.TagMapper;
import com.tipo.witter.mapper.TweetMapper;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.pojo.TweetIn;
import com.tipo.witter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20199:47 AM
 */
@Service
public class TweetServiceImpl implements TweetService {
    @Autowired
    private TweetMapper mapper;
    @Autowired
    private TagMapper tagMapper;
    @Override
    public Msg addTweet(TweetIn in) {
        if (mapper.addTweet(in)==1){
            return Msg.success(in.getId());
        }
        return Msg.fail();
    }

    @Override
    public Msg findTweetList(Integer top, Long time) {
        return Msg.success(mapper.findTweetList(top,new Timestamp(time))) ;
    }

    @Override
    public Msg deleteTweet(Integer id) {
        tagMapper.deleteMap(id,0);
        if (mapper.deleteTweet(id)==1){
            return Msg.success();
        }
        return Msg.fail();
    }

    @Override
    public Msg findTweetByTag(Integer tagId,Integer top,Long time) {
        return Msg.success(mapper.findTweetByTag(top,new Timestamp(time),tagId));
    }

    @Override
    public Msg addPower(Integer id, Integer power) {
        if (mapper.addPower(id,power)==1){
            return Msg.success();
        }
        return Msg.fail();
    }
}
