package com.antra.homework2.controller;

import com.antra.homework2.dto.StudentDTO;
import com.antra.homework2.dto.StudentDetailsDTO;
import com.antra.homework2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping(path = "/save")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO studentSave = studentService.addStudent(studentDTO);
        return studentSave;
    }

    @GetMapping(path = "/getAllStudents")
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @GetMapping(path = "/details/{id}")
    public StudentDetailsDTO getStudentDetails(@PathVariable Integer id) {
        StudentDetailsDTO studentDetails = studentService.getStudentDetails(id);
        return studentDetails;
    }

}
