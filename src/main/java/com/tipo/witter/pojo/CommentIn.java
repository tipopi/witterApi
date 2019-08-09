package com.tipo.witter.pojo;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20193:43 PM
 */
public class CommentIn {
    private Integer userId;
    private Integer href;
    private Integer type;
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
