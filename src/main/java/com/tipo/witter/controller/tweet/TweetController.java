package com.tipo.witter.controller.tweet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
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
        return service.addTweet(in.getUserId(),in.getText());
    }
    @GetMapping("findList")
    public Msg findList(@RequestParam(value = "time") Long time){
        return service.findTweetList(IntStatic.TWEET_FIRST_COUNT,time);
    }
    @GetMapping("findGlide")
    public Msg findGlide(@RequestParam(value = "time") Long time){
        return service.findTweetList(IntStatic.TWEET_GLIDE_COUNT,time);
    }
    @DeleteMapping("tweet")
    public Msg deleteTweet(@RequestBody String json ) throws IOException {
        JsonNode node=objectMapper.readTree(json);
        Integer id=node.get("id").asInt();
        if (id<0){
            return Msg.fail();
        }
        return service.deleteTweet(id);
    }
    @GetMapping("findByTag")
    public Msg findByTag(@RequestParam("tagId") Integer tagId){
        if (tagId<0){
            return Msg.fail();
        }
        return service.findTweetByTag(tagId);
    }
}
