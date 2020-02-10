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
    Msg findTweetList(Integer top,Long time,Integer offset);
    /**
     * 伪删方案，有tag和tagmap依赖，一并处理
     * @date 10:30 AM 8/22/2019
     * @return com.tipo.witter.pojo.Msg
     **/
    Msg deleteTweet(Integer id);
    Msg findTweetByTag(Integer tagId,Integer top,Long time,Integer offset);
    Msg addPower(Integer id,Integer power);
}
