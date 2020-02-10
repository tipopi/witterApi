package com.tipo.witter.pojo;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/9 16:16
 */
public class ContentIn {
    private Integer contentId;
    private String content;

    public ContentIn() {
    }

    public ContentIn(String content) {
        this.content = content;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ContentIn{" +
                "contentId=" + contentId +
                ", content='" + content + '\'' +
                '}';
    }
}
