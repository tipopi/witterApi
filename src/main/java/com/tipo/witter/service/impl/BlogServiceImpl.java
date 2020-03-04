package com.tipo.witter.service.impl;
import java.util.ArrayList;
import	java.util.Date;
import java.util.List;

import com.tipo.witter.exception.RollBackException;
import com.tipo.witter.mapper.BlogMapper;
import com.tipo.witter.mapper.TagMapper;
import com.tipo.witter.pojo.*;
import com.tipo.witter.service.BlogService;
import com.tipo.witter.tool.IntStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/3 14:45
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper mapper;
    @Autowired
    private TagMapper tagMapper;
    @Override
    public Msg findList(Long time, Integer size, Integer page,String tagId) {
        if(size==null){
            size=IntStatic.TWEET_FIRST_COUNT;
        }
        if("all".equals(tagId)){
            return Msg.success(mapper.findList(new Date(time),(page-1)*size,size));
        }
        Integer tag=Integer.valueOf(tagId);
        return Msg.success(mapper.findListByTag(new Date(time),(page-1)*size,size,tag));

    }

    @Override
    public Msg getContent(Integer blogId) {
        BlogContent content=new BlogContent();
        content.setContent(mapper.getContent(blogId));
        content.setTags(tagMapper.findTagByHref(blogId,1));
        return Msg.success(content);
    }

    @Override
    @Transactional(rollbackFor = RollBackException.class)
    public Msg addBlog(BlogIn in) {
        ContentIn cIn=new ContentIn(in.getContent());
        mapper.addContent(cIn);
        in.setContentId(cIn.getContentId());
        mapper.addBlog(in);
        Integer blogId=in.getBlogId();
        if(in.getTags()!=null&&!in.getTags().isEmpty()){
            addTags(in.getTags(),blogId);
        }
        return Msg.success();
    }

    @Override
    @Transactional(rollbackFor = RollBackException.class)
    public Msg updateBlog(BlogUp up) {
        boolean change=false;
        if(up.getContent()!=null){
            mapper.updateContent(up.getContentId(),up.getContent());
            change=true;
        }
        if(up.getDescription()!=null){
            mapper.updateBlog(up);
            change=true;
        }
        if(up.getTags()!=null&&!up.getTags().isEmpty()){
            addTags(up.getTags(),up.getBlogId());
            change=true;
        }
        if(change){
            return Msg.success(mapper.getBlog(up.getBlogId()));
        }
        return Msg.success("no change");
    }

    @Override
    @Transactional(rollbackFor = RollBackException.class)
    public Msg deleteBlog(Integer blogId) {
        tagMapper.deleteMap(blogId,1);
        if(mapper.deleteBlog(blogId)==1){
            return Msg.success();
        }
        return Msg.fail();
    }

    @Override
    public Msg addBrowse(Integer blogId) {
        if(mapper.addBrowse(blogId)==1){
            return Msg.success();
        }
        return Msg.fail();
    }

    private void addTags(List<TagItem> tags,Integer blogId){
        Integer type=1;
        List<TagMap> tagMap=new ArrayList<>();
        tags.forEach(tagItem -> {
            String name=tagItem.getName();
            Integer tagId=tagMapper.findTagByName(name,type);
            if(tagId==null){
                TagIn tagIn=new TagIn(name,type);
                tagMapper.addTag(tagIn);
                tagId=tagIn.getId();
            }
            tagMap.add(new TagMap(blogId,tagId,type));
        });
        tagMapper.addMap(tagMap);
    }
}
