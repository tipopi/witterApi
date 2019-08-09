package com.tipo.witter.pojo;

import java.sql.Timestamp;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/8/20195:12 PM
 */
public class TweetResult {
    private Integer tweetId;
    private Integer userId;
    private String text;
    private Integer power;
    private Timestamp createTime;

    public TweetResult() {
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public void setTweetId(Integer tweetId) {
        this.tweetId = tweetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TweetResult{" +
                "tweetId=" + tweetId +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", power=" + power +
                ", createTime=" + createTime +
                '}';
    }
}
