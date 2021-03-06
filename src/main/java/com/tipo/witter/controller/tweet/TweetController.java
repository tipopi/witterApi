package com.tipo.witter.controller.tweet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tipo.witter.annotation.Security;
import com.tipo.witter.enums.RoleEnum;
import com.tipo.witter.pojo.Msg;
import com.tipo.witter.pojo.TweetIn;
import com.tipo.witter.service.TweetService;
import com.tipo.witter.tool.IntStatic;
import com.tipo.witter.util.http.ErrorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**推文
 * @author Tipo
 * @version 1.0
 * @date 8/9/20199:45 AM
 */
@RestController
@RequestMapping("tweet")
public class TweetController {
    @Autowired
    private TweetService service;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("addTweet")
    public Msg addTweet(@RequestBody @Validated TweetIn in, BindingResult binding){
        if (binding.hasErrors()){
            return Msg.fail();
        }
        return service.addTweet(in);
    }
    @GetMapping("findList")
    public Msg findList(@RequestParam(value = "time") Long time,@RequestParam(value = "page")Integer page){
        return service.findTweetList(IntStatic.TWEET_FIRST_COUNT,time,(page-1)*IntStatic.TWEET_FIRST_COUNT);
    }

    @Security(roles = {RoleEnum.ADMIN},createToken = true,checkToken =true )
    @DeleteMapping("delete")
    public Msg deleteTweet(@RequestParam("id") Integer id ) throws IOException {
        if (id<0){
            return Msg.fail();
        }
        return service.deleteTweet(id);
    }
    @GetMapping("findByTag")
    public Msg findByTag(@RequestParam("tagId") Integer tagId,@RequestParam(value = "time") Long time,@RequestParam(value = "page")Integer page){
        if (tagId<0){
            return Msg.fail();
        }
        return service.findTweetByTag(tagId,IntStatic.TWEET_FIRST_COUNT,time,(page-1)*IntStatic.TWEET_FIRST_COUNT);
    }
    @PutMapping("addPower")
    public Msg addPower(@RequestBody String json) throws IOException {
        JsonNode node=objectMapper.readTree(json);
        Integer id=node.get("id").asInt();
        Integer power=node.get("power").asInt();
        return service.addPower(id,power);
    }
}
