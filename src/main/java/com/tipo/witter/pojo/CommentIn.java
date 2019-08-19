package com.tipo.witter.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20193:43 PM
 */
public class CommentIn {
    private Integer id;
    @NotNull
    @Max(1)
    @Min(0)
    private Integer userId;
    @Min(0)
    private Integer href;
    @Min(0)
    private Integer type;
    @Length(max = 255)
    private String text;

    public CommentIn() {
    }

    public CommentIn(Integer userId, Integer href, Integer type, String text) {
        this.userId = userId;
        this.href = href;
        this.type = type;
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHref() {
        return href;
    }

    public void setHref(Integer href) {
        this.href = href;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CommentIn{" +
                "userId=" + userId +
                ", href=" + href +
                ", type=" + type +
                ", text='" + text + '\'' +
                '}';
    }
}
