package com.tipo.witter.mapper;

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
    Integer addTweet(@Param("userId")Integer userId,@Param("text")String text );
    List<TweetResult> findTweetList(@Param("TOP") Integer top, @Param("createTime")Timestamp createTime);
    Integer deleteTweet(Integer id);
}
