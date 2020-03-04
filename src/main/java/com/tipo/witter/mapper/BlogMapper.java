package com.tipo.witter.mapper;


import com.tipo.witter.pojo.BlogIn;
import com.tipo.witter.pojo.BlogItem;
import com.tipo.witter.pojo.BlogUp;
import com.tipo.witter.pojo.ContentIn;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/3 14:32
 */
public interface BlogMapper {
    List<BlogItem> findList(@Param("createTime")Date time, @Param("offset")Integer offset, @Param("size")Integer size);
    List<BlogItem> findListByTag(@Param("createTime")Date time, @Param("offset")Integer offset, @Param("size")Integer size,@Param("tagId")Integer tag);
    String getContent(@Param("blogId") Integer blogId);
    Integer addContent(ContentIn in);
    Integer addBlog(BlogIn in);
    Integer updateBlog(BlogUp in);
    Integer updateContent(@Param("contentId")Integer contentId,@Param("content")String content);
    BlogItem getBlog(@Param("blogId")Integer blogId);
    Integer deleteBlog(@Param("blogId")Integer blogId);
    Integer addBrowse(@Param("blogId")Integer blogId);
}
