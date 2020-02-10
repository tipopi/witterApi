package com.tipo.witter.controller.blog;

import com.tipo.witter.pojo.BlogIn;
import com.tipo.witter.pojo.BlogUp;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/3 14:57
 */
@RestController
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private BlogService service;
    @GetMapping("findList")
    public Msg findList(@RequestParam("time")Long time,
                        @RequestParam(value = "size",required =false)Integer size,
                        @RequestParam("page")Integer page,
                        @RequestParam("tagId")String tagId){
        return service.findList(time,size,page,tagId);
    }
    @GetMapping("content")
    public Msg getContent(@RequestParam("blogId")Integer id){
        return service.getContent(id);
    }
    @PostMapping("add")
    public Msg addBlog(@Validated @RequestBody BlogIn in, BindingResult binding){
        if (binding.hasErrors()){
            return Msg.fail();
        }
        return service.addBlog(in);
    }
    @PutMapping("update")
    public Msg updateBlog(@Validated @RequestBody BlogUp up , BindingResult binding){
        if (binding.hasErrors()){
            return Msg.fail();
        }
        return service.updateBlog(up);
    }
}
