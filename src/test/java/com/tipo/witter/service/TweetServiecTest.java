package com.tipo.witter.service;

import com.tipo.witter.mapper.TweetMapper;
import com.tipo.witter.pojo.TweetResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/201911:06 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TweetServiecTest {
    @Autowired
    private TweetService service;
    @Autowired
    private TweetMapper mapper;
    @Test
    public void addTweet(){
        for (int i=8;i<12;i++){
//            service.addTweet(1,"撒大苏打实打实"+i);
        }
    }
    @Test
    public void findAll(){
        for (TweetResult result:mapper.findTweetList(10,new Timestamp(System.currentTimeMillis()))){
            System.out.println(result);
        }

    }
    @Test
    public void findByTag(){

    }


}
