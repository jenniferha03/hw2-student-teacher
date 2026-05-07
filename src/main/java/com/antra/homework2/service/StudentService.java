package com.antra.homework2.service;

import com.antra.homework2.dto.StudentDTO;
import com.antra.homework2.dto.StudentDetailsDTO;

import java.util.List;

public interface StudentService {

    StudentDTO addStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDetailsDTO getStudentDetails(Integer id);
}
