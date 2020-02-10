package com.tipo.witter.mapper;

import com.tipo.witter.pojo.TweetIn;
import com.tipo.witter.pojo.TweetResult;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/8/20195:18 PM
 */
public interface TweetMapper {
    Integer addTweet(TweetIn in);
    List<TweetResult> findTweetList(@Param("size") Integer size, @Param("createTime") Date createTime,@Param("offset")Integer offset);
    Integer deleteTweet(Integer id);
    List<TweetResult> findTweetByTag(@Param("size") Integer size, @Param("createTime")Date createTime,@Param("tag")Integer tag,@Param("offset")Integer offset);
    Integer addPower(@Param("id")Integer id,@Param("power")Integer power);
}
