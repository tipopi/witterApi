package com.tipo.witter.service;

import com.tipo.witter.mapper.TweetMapper;
import com.tipo.witter.pojo.TweetIn;
import com.tipo.witter.pojo.TweetResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


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
        for (int i=1;i<100;i++){
            TweetIn in=new TweetIn();
            in.setText("test"+i);
            in.setUserId(1);
            service.addTweet(in);
        }
    }
    @Test
    public void findAll(){
//        for (TweetResult result:mapper.findTweetList(10,new Date(System.currentTimeMillis()),0)){
//            System.out.println(result);
//        }
        System.out.println(new Date());

    }
    @Test
    public void findByTag(){

    }


}
