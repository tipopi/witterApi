package com.tipo.witter.pojo;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20192:05 PM
 */
public class TagIn {
    private Integer id;
    private String name;

    public TagIn() {
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

    @Override
    public String toString() {
        return "TagIn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
