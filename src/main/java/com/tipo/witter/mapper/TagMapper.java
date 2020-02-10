package com.tipo.witter.mapper;

import com.tipo.witter.pojo.TagCount;
import com.tipo.witter.pojo.TagIn;
import com.tipo.witter.pojo.TagItem;
import com.tipo.witter.pojo.TagMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20191:51 PM
 */
public interface TagMapper {
    Integer addTag(TagIn in);
    Integer addMap(List<TagMap> list);
    Integer findTagByName(@Param("name")String name,@Param("type")Integer type);
    List<TagCount> findTagCount(Integer type);
    List<TagItem> findTagByHref(@Param("href") Integer href, @Param("type")Integer type);
    Integer deleteMap(@Param("href")Integer href,@Param("type")Integer type);
    Integer deleteTag(Integer tagId);
}
