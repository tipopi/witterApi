package com.tipo.witter.controller.common;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.qiniu.util.Auth;
import com.tipo.witter.tool.BaseStatic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**预留图片接口
 * @author Tipo
 * @version 1.0
 * @date 8/10/2019 1:27 PM
 */
@RestController
public class PicController {
    @GetMapping("picToken")
    public Map<String, String> getToken(){
        String accessKey = BaseStatic.ACCESS_KEY;
        String secretKey = BaseStatic.SECRET_KEY;
        String bucket = BaseStatic.BUCKET;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        Map<String, String> map=new HashMap<>(1);
        map.put("token",upToken);
        return map;
    }
}
