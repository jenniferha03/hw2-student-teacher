package com.antra.homework2.service;

import com.antra.homework2.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {

    TeacherDTO addTeacher(TeacherDTO teacherDTO);

    List<TeacherDTO> getAllTeachers();
}
