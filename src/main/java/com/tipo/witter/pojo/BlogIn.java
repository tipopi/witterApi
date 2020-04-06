package com.tipo.witter.pojo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/9 14:12
 */
public class BlogIn {
    private Integer blogId;
    @NotNull
    private String title;
    private Integer contentId;
    private String description;
    @NotNull
    private String content;
    private List<TagItem> tags;
    private List <String> images;
    public BlogIn() {
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Integer getBlogId() {
        return this.blogId;
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
        return "BlogIn{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", contentId=" + contentId +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                ", images=" + images +
                '}';
    }
}
