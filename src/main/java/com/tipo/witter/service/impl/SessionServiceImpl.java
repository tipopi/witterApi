package com.tipo.witter.service.impl;

import com.tipo.witter.enums.RoleEnum;
import com.tipo.witter.pojo.Account;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.service.SessionService;
import com.tipo.witter.tool.BaseStatic;
import com.tipo.witter.util.http.RequestUtil;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author Tipo
 * @version 1.0
 * @date 2019/8/12 17:53
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Override
    public Msg addSession(Account account) throws UnsupportedEncodingException {
        if (account.isRemember()){

        }
        else {
            RequestUtil.login(account.getUsername(), BaseStatic.ADMIN_NAME, RoleEnum.ADMIN);
        }

        return null;
    }
}
