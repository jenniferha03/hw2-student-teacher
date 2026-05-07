package com.antra.homework2.controller;

import com.antra.homework2.dto.StudentDTO;
import com.antra.homework2.dto.TeacherDTO;
import com.antra.homework2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping(path = "/save")
    public TeacherDTO saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        TeacherDTO teacherSave = teacherService.addTeacher(teacherDTO);
        return teacherSave;
    }

    @GetMapping(path = "/getAllTeachers")
    public List<TeacherDTO> getAllTeachers() {
        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
        return allTeachers;
    }

}
