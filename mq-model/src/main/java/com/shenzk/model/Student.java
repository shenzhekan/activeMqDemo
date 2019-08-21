package com.shenzk.model;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -2932916335596934421L;

    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
