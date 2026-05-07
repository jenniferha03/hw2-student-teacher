package com.antra.homework2.service.IMPL;

import com.antra.homework2.entity.Student;
import com.antra.homework2.entity.StudentTeacher;
import com.antra.homework2.entity.Teacher;
import com.antra.homework2.repo.StudentRepository;
import com.antra.homework2.repo.StudentTeacherRepository;
import com.antra.homework2.repo.TeacherRepository;
import com.antra.homework2.service.StudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentTeacherServiceImpl implements StudentTeacherService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentTeacherRepository studentTeacherRepository;

    @Override
    @Transactional
    public void assignTeacherToStudent(Integer s_id, Integer t_id) {

        if (s_id == null || t_id == null) {
            System.out.println("Student ID or Teacher ID is null!");
            return;
        }

        Optional<Student> studentOptional = studentRepository.findById(s_id);
        Optional<Teacher> teacherOptional = teacherRepository.findById(t_id);

        if (studentOptional.isPresent() && teacherOptional.isPresent()) {

            StudentTeacher studentTeacher = new StudentTeacher();

            studentTeacher.setStudent(studentOptional.get());
            studentTeacher.setTeacher(teacherOptional.get());

            studentTeacherRepository.save(studentTeacher);

        }

        else {
            throw new RuntimeException("Student ID" + s_id + " or " + "Teacher ID " + t_id + " Not Found !!!");
        }
    }

}
