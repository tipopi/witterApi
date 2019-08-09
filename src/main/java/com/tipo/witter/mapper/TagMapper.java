package com.tipo.witter.mapper;

import com.tipo.witter.pojo.TagCount;
import com.tipo.witter.pojo.TagIn;
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
    Integer findTagByName(String name);
    List<TagCount> findTagCount(Integer type);
    List<String> findTagByHref(Integer href);
}
