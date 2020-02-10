package com.tipo.witter.pojo;

import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/7 15:18
 */
public class BlogContent {
    private String content;
    private List<TagItem> tags;

    public BlogContent() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<TagItem> getTags() {
        return tags;
    }

    public void setTags(List<TagItem> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "BlogContent{" +
                "content='" + content + '\'' +
                ", tags=" + tags +
                '}';
    }
}
