package com.tipo.witter.pojo;

/**
 * @author Tipo
 * @version 1.0
 * @date 2020/2/6 16:17
 */
public class TagItem {
    private Integer tagId;
    private String name;

    public TagItem() {
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

    @Override
    public String toString() {
        return "TagItem{" +
                "tagId=" + tagId +
                ", name='" + name + '\'' +
                '}';
    }
}
