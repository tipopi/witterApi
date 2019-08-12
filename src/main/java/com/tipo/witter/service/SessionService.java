package com.tipo.witter.service;

import com.tipo.witter.pojo.Account;
import com.tipo.witter.pojo.Msg;

import java.io.UnsupportedEncodingException;

/**
 * @author Tipo
 * @version 1.0
 * @date 2019/8/12 17:52
 */
public interface SessionService {
    Msg addSession(Account account) throws UnsupportedEncodingException;
}
