package org.example;

public class Human {
    Integer id;
    String name;
    Integer age;
    String comment;

    public Human(Integer id, String name, Integer age, String comment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.comment = comment;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
