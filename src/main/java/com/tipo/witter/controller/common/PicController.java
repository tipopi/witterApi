package com.tipo.witter.controller.common;

import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**预留图片接口
 * @author Tipo
 * @version 1.0
 * @date 8/10/2019 1:27 PM
 */
@RestController
public class PicController {
    @GetMapping("picToken")
    public String getToken(){
        String accessKey = "MJm_bXHCN_sS_q30S76MoC1eO7MOWQAII8hN_sbE";
        String secretKey = "bY0Ovfvjw3vkied8i_U8tYq8arhximrzdaz8k_8e";
        String bucket = "witter-pi";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }
}
