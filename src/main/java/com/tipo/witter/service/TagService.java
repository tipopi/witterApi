package com.tipo.witter.service;

import com.tipo.witter.pojo.Msg;
import com.tipo.witter.pojo.TagIn;

import java.util.List;

/**标签与推文|文章都是多对多，所以需要映射，添加标签和映射w
 * @author Tipo
 * @version 1.0
 * @date 8/10/2019 8:53 AM
 */
public interface TagService {
    Msg addTag(TagIn in);
    Msg addMap(List<Integer> tags ,Integer href,Integer type);
    Msg findTagCount(Integer type);
    Msg findByHref(Integer href);
}
