package com.tipo.witter.mapper;

import com.tipo.witter.pojo.TweetIn;
import com.tipo.witter.pojo.TweetResult;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/8/20195:18 PM
 */
public interface TweetMapper {
    Integer addTweet(TweetIn in);
    List<TweetResult> findTweetList(@Param("TOP") Integer top, @Param("createTime")Timestamp createTime);
    Integer deleteTweet(Integer id);
    List<TweetResult> findTweetByTag(@Param("TOP") Integer top, @Param("createTime")Timestamp createTime,@Param("tag")Integer tag);
    Integer addPower(@Param("id")Integer id,@Param("power")Integer power);
}
