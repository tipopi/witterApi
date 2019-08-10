package com.tipo.witter.controller.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tipo.witter.pojo.CommentIn;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.Map;


/**
 * @author Tipo
 * @version 1.0
 * @date 8/10/2019 1:27 PM
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService service;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("add")
    public Msg add(@RequestBody CommentIn in, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return Msg.fail();
        }
        return service.addComment(in);
    }
    @GetMapping("find")
    public Msg find(@RequestParam("href") Integer href,
                    @RequestParam("type")Integer type){
        return service.findComment(href,type);
    }
    @DeleteMapping("delete")
    public Msg delete(@RequestBody String json) throws IOException {
        JsonNode node=objectMapper.readTree(json);
        Integer id=node.get("id").asInt();
        if (id<0){
            return Msg.fail();
        }
        return service.deleteComment(id);
    }
}
