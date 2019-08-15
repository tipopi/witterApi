package com.tipo.witter.service.impl;

import com.tipo.witter.enums.RoleEnum;
import com.tipo.witter.pojo.Account;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.SessionService;
import com.tipo.witter.tool.BaseStatic;
import com.tipo.witter.util.http.RequestUtil;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author Tipo
 * @version 1.0
 * @date 2019/8/12 17:53
 */
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private StringEncryptor encryptor;
    @Value("${admin.user}")
    private String user;
    @Value("${admin.pass}")
    private String pass;

    @Override
    public Msg addSession(Account account) throws UnsupportedEncodingException {
        if (encryptor.decrypt(user).equals(account.getUsername())||encryptor.decrypt(pass).equals(account.getPassword())){
            RequestUtil.login(account.getUsername(), BaseStatic.ADMIN_NAME, RoleEnum.ADMIN);
            return Msg.success();
        }
        return Msg.fail();
    }

    @Override
    public Msg deleteSession() {
        RequestUtil.logout();
        return Msg.fail();
    }
}
