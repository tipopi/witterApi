package com.tipo.witter.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author Tipo
 * @version 1.0
 * @date 8/9/20192:05 PM
 */
public class TagIn {
    private Integer id;
    @Length(max = 10)
    @NotNull
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
