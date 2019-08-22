package com.tipo.witter.controller.common;


import com.tipo.witter.annotation.Security;
import com.tipo.witter.enums.RoleEnum;
import com.tipo.witter.pojo.CommentIn;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


/**评论
 * @author Tipo
 * @version 1.0
 * @date 8/10/2019 1:27 PM
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService service;

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
    @Security(roles = {RoleEnum.ADMIN},createToken = true,checkToken =true )
    @DeleteMapping("delete")
    public Msg delete(@RequestParam("id") Integer id) throws IOException {
        if (id<0){
            return Msg.fail();
        }
        return service.deleteComment(id);
    }
}
