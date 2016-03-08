package com.lindec.springboot.repository;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lindec on 2016/3/8.
 */
@Document(collection = "person")
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
