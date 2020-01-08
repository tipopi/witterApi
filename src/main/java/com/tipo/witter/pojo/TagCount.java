package com.tipo.witter.pojo;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20194:12 PM
 */
public class TagCount {
    private Integer tagId;
    private String name;
    private Integer tagCount;

    public TagCount() {
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

    @Override
    public String toString() {
        return "TagCount{" +
                "tagId=" + tagId +
                ", name='" + name + '\'' +
                ", tagCount=" + tagCount +
                '}';
    }
}
