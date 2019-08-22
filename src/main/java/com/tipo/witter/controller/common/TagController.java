package com.tipo.witter.controller.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.pojo.TagIn;
import com.tipo.witter.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**标签是推文和文章通用的
 * @author Tipo
 * @version 1.0
 * @date 8/10/2019 2:56 PM
 */
@RestController
@RequestMapping("tag")
public class TagController {
    @Autowired
    private TagService service;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("add")
    public Msg add(@RequestBody @Validated TagIn in, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return Msg.fail();
        }
        return service.addTag(in);
    }
    @PostMapping("addMap")
    public Msg addMap(@RequestBody String json) throws IOException {
        JsonNode node=objectMapper.readTree(json);
        JsonNode tagNode=node.get("tags");
        List<Integer> tags=new ArrayList<>();
        tagNode.forEach(jsonNode -> {
            tags.add(jsonNode.asInt());
        });
        Integer href=node.get("href").asInt();
        Integer type=node.get("type").asInt();
        return service.addMap(tags,href,type);
    }
    @GetMapping("findCount")
    public Msg findCount(@RequestParam("type")Integer type){
        return service.findTagCount(type);
    }
    @GetMapping("findHref")
    public Msg findHref(@RequestParam("href")Integer href){
        return service.findByHref(href);
    }
}
