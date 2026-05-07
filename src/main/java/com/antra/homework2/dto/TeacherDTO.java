package com.antra.homework2.dto;

public class TeacherDTO {

    private Integer id;
    private String name;

    public TeacherDTO() {
    }

    public TeacherDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeacherDTO(String name) {
        this.name = name;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
