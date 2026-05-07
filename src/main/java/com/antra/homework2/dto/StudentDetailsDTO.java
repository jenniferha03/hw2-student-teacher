package com.antra.homework2.dto;

import java.util.List;

public class StudentDetailsDTO {

    private Integer id;
    private String name;
    private List<TeacherDTO> teachers;

    public StudentDetailsDTO() {
    }

    public StudentDetailsDTO(List<TeacherDTO> teachers, String name, Integer id) {
        this.teachers = teachers;
        this.name = name;
        this.id = id;
    }

    public StudentDetailsDTO(String name, List<TeacherDTO> teachers) {
        this.name = name;
        this.teachers = teachers;
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

    public List<TeacherDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherDTO> teachers) {
        this.teachers = teachers;
    }
}
