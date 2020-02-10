package com.tipo.witter.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/3 14:35
 */
public class BlogItem {
    private Integer blogId;
    private String title;
    private Integer contentId;
    private String description;
    private Integer browse;
    private Date createTime;
    private String content;
    private List<TagItem> tags;
    public BlogItem() {
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
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

    public Integer getBrowse() {
        return browse;
    }

    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TagItem> getTags() {
        return tags;
    }

    public void setTags(List<TagItem> tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlogItem{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", contentId=" + contentId +
                ", description='" + description + '\'' +
                ", browse=" + browse +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                '}';
    }
}
