package com.tipo.witter.pojo;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20194:12 PM
 */
public class TagCount {
    private Integer id;
    private String name;
    private Integer tagCount;

    public TagCount() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", tagCount=" + tagCount +
                '}';
    }
}
