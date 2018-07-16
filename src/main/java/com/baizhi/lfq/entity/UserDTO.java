package com.baizhi.lfq.entity;

import javax.management.StringValueExp;

/**
 * Created by 14832 on 2018/7/9.
 */
public class UserDTO {
    private String name;
   private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public UserDTO() {
    }

    public UserDTO(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
