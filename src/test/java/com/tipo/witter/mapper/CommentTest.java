package com.tipo.witter.mapper;

import com.tipo.witter.mapper.CommentMapper;
import com.tipo.witter.pojo.CommentIn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {
    @Autowired
    private CommentMapper mapper;
    @Test
    public void addComment(){
        for (int i=0;i<2;i++){
            mapper.addComment(new CommentIn(0,1,0,"评论"+i));
        }
    }
    @Test
    public void find(){
        mapper.deleteComment(1);
        System.out.println(mapper.findComment(1,0));
    }
}