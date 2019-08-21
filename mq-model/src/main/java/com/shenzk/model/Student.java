package com.shenzk.model;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -2932916335596934421L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
