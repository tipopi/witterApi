package com.tipo.witter.pojo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/10 16:28
 */
public class BlogUp {
    @NotNull
    private Integer blogId;
    private String title;
    @NotNull
    private Integer contentId;
    private String description;
    private String content;
    private List<TagItem> tags;

    public BlogUp() {
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "BlogUp{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", contentId=" + contentId +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                '}';
    }
}
