package com.antra.homework2.controller;

import com.antra.homework2.service.StudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assign")
public class StudentTeacherController {

    @Autowired
    private StudentTeacherService studentTeacherService;

    @PostMapping(path = "/student-to-teacher")
    public String assignTeacherToStudent(
            @RequestParam Integer student_id,
            @RequestParam Integer teacher_id) {

        studentTeacherService.assignTeacherToStudent(student_id, teacher_id);

        return "Successfully Assigned Student ID: " + student_id + " and" + " Teacher ID: " + teacher_id + " !!!";
    }

}
