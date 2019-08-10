package com.tipo.witter.service.impl;

import com.tipo.witter.mapper.TagMapper;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.pojo.TagIn;
import com.tipo.witter.pojo.TagMap;
import com.tipo.witter.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/10/2019 8:53 AM
 */
@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagMapper mapper;
    @Override
    public Msg addTag(TagIn in) {
        Integer tagId=mapper.findTagByName(in.getName());
        if (tagId!=null){
            in.setId(tagId);
            return Msg.success(in);
        }
        if (mapper.addTag(in)==1){
            return Msg.success(in);
        }
        return Msg.fail();
    }

    @Override
    public Msg addMap(List<Integer>tags, Integer href, Integer type) {
        List<TagMap> map=new ArrayList<>();
        for (Integer tag:tags){
            map.add(new TagMap(href,tag,type));
        }
        if (mapper.addMap(map)>0){
            return Msg.success();
        }
        return Msg.fail();
    }

    @Override
    public Msg findTagCount(Integer type) {
        return Msg.success(mapper.findTagCount(type));
    }

    @Override
    public Msg findByHref(Integer href) {
        return Msg.success(mapper.findTagByHref(href));
    }
}
