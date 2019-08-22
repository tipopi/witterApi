package com.tipo.witter.service;

import com.tipo.witter.pojo.Account;
import com.tipo.witter.pojo.Msg;

import java.io.UnsupportedEncodingException;

/**单管理员情况直接使用加密文件内容验证，如需记住功能迁移至数据库，或将token放入redis，最蠢的方法是放入文件读写
 * @author Tipo
 * @version 1.0
 * @date 2019/8/12 17:52
 */
public interface SessionService {
    /**
     * 目前采用加密文件
     * @date 10:32 AM 8/22/2019
     * @return com.tipo.witter.pojo.Msg
     **/
    Msg addSession(Account account) throws UnsupportedEncodingException;
    Msg deleteSession();
}
