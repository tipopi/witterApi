package com.tipo.witter.mapper;

import com.tipo.witter.mapper.TagMapper;
import com.tipo.witter.pojo.TagIn;
import com.tipo.witter.pojo.TagMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20191:55 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagMapperTest {
    @Autowired
    private TagMapper mapper;
    @Test
    public void addTag(){
        TagIn in=new TagIn();
        in.setName("c艹");
        mapper.addTag(in);
        System.out.println(in);
    }
    @Test
    public void addMap(){
        List<TagMap> list=new ArrayList<>();
        list.add(new TagMap(1,1,0));
        list.add(new TagMap(1,2,0));
        list.add(new TagMap(1,3,0));
        mapper.addMap(list);
    }
    @Test
    public void find(){
        System.out.println(mapper.findTagCount(0));
        System.out.println(mapper.findTagByName("java"));
        System.out.println(mapper.findTagByHref(1));
    }
}
