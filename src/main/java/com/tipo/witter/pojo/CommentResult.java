package com.tipo.witter.pojo;

import java.sql.Timestamp;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20192:02 PM
 */
public class CommentResult {
    private Integer id;
    private Integer userId;
    private String text;
    private Timestamp createTime;

    public CommentResult() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CommentResult{" +
                "id=" + id +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
