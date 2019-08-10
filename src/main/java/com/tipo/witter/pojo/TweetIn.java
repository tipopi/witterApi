package com.tipo.witter.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/10/2019 1:31 PM
 */
public class TweetIn {
    @NotNull
    @Max(1)
    @Min(0)
    private Integer userId;
    @Length(max = 255)
    private String text;

    public TweetIn() {
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

    @Override
    public String toString() {
        return "TweetIn{" +
                "userId=" + userId +
                ", text='" + text + '\'' +
                '}';
    }
}
