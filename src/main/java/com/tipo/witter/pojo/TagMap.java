package com.tipo.witter.pojo;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20194:04 PM
 */
public class TagMap {
    private Integer href;
    private Integer tagId;
    private Integer type;

    public TagMap() {
    }

    public TagMap(Integer href, Integer tagId, Integer type) {
        this.href = href;
        this.tagId = tagId;
        this.type = type;
    }

    public Integer getHref() {
        return href;
    }

    public void setHref(Integer href) {
        this.href = href;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TagMap{" +
                "href=" + href +
                ", tagId=" + tagId +
                ", type=" + type +
                '}';
    }
}
