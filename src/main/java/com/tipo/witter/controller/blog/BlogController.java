package com.tipo.witter.controller.blog;

import com.tipo.witter.annotation.Security;
import com.tipo.witter.enums.RoleEnum;
import com.tipo.witter.pojo.BlogIn;
import com.tipo.witter.pojo.BlogUp;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    @Security(roles = {RoleEnum.ADMIN,RoleEnum.VISITOR})
    @GetMapping("findList")
    public Msg findList(@RequestParam("time")Long time,
                        @RequestParam(value = "size",required =false)Integer size,
                        @RequestParam("page")Integer page,
                        @RequestParam("tagId")String tagId){
        return service.findList(time,size,page,tagId);
    }

    @GetMapping("test")
    public Map<String, String> test(){
        Map<String, String> map=new HashMap<>();
        map.put("url","https://pic1.zhimg.com/v2-3b4fc7e3a1195a081d0259246c38debc_1200x500.jpg");
        return map;
    }
    @Security(roles = {RoleEnum.ADMIN,RoleEnum.VISITOR})
    @GetMapping("content")
    public Msg getContent(@RequestParam("blogId")Integer id){
        return service.getContent(id);
    }

    @Security(roles = {RoleEnum.ADMIN},createToken = true,checkToken =true )
    @PostMapping("add")
    public Msg addBlog(@Validated @RequestBody BlogIn in, BindingResult binding){
        if (binding.hasErrors()){
            return Msg.fail();
        }
        return service.addBlog(in);
    }

    @Security(roles = {RoleEnum.ADMIN},createToken = true,checkToken =true )
    @PutMapping("update")
    public Msg updateBlog(@Validated @RequestBody BlogUp up , BindingResult binding){
        if (binding.hasErrors()){
            return Msg.fail();
        }
        return service.updateBlog(up);
    }

    @Security(roles = {RoleEnum.ADMIN},createToken = true,checkToken =true )
    @DeleteMapping("delete")
    public Msg deleteBlog(@RequestParam("blogId")Integer id){
        return service.deleteBlog(id);
    }

    @GetMapping("addBrowse")
    public Msg addBrowse(@RequestParam("blogId")Integer id){
        return service.addBrowse(id);
    }
}
