package com.tipo.witter.controller.common;

import com.tipo.witter.annotation.Security;
import com.tipo.witter.enums.RoleEnum;
import com.tipo.witter.pojo.Account;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**登录和注销
 * @author Tipo
 * @version 1.0
 * @date 2019/8/12 15:02
 */
@RestController
public class SessionController {
    @Autowired
    private SessionService service;
    @Security(roles = {RoleEnum.LOGIN},createToken = true)
    @PostMapping("addSession")
    public Msg addSession(@RequestBody @Validated Account account, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            return Msg.fail();
        }
        return service.addSession(account);
    }
    @GetMapping("deleteSession")
    public Msg deleteSession(){
        return service.deleteSession();
    }

}
