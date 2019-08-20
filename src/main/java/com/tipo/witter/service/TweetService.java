package com.tipo.witter.service;

import com.tipo.witter.pojo.Msg;
import com.tipo.witter.pojo.TweetIn;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20199:41 AM
 */
public interface TweetService {
    Msg addTweet(TweetIn in);
    Msg findTweetList(Integer top,Long time);
    Msg deleteTweet(Integer id);
    Msg findTweetByTag(Integer tagId,Integer top,Long time);
    Msg addPower(Integer id,Integer power);
}
