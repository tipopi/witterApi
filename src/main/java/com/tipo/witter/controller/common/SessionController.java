package com.tipo.witter.controller.common;

import com.tipo.witter.pojo.Account;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @author Tipo
 * @version 1.0
 * @date 2019/8/12 15:02
 */
@RestController
public class SessionController {
    @Autowired
    private SessionService service;
    @PostMapping("addSession")
    public Msg addSession(@RequestBody @Validated Account account, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            return Msg.fail();
        }
        return service.addSession(account);
    }

}
