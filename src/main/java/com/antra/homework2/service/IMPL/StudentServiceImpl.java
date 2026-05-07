package com.antra.homework2.service.IMPL;

import com.antra.homework2.dto.StudentDTO;
import com.antra.homework2.dto.StudentDetailsDTO;
import com.antra.homework2.dto.TeacherDTO;
import com.antra.homework2.entity.Student;
import com.antra.homework2.entity.StudentTeacher;
import com.antra.homework2.entity.Teacher;
import com.antra.homework2.repo.StudentRepository;
import com.antra.homework2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    @Transactional
    public StudentDTO addStudent(StudentDTO studentDTO) {

        Student student = new Student(
                studentDTO.getName()
        );

        Student studentSave = studentRepository.save(student);
        return new StudentDTO(studentSave.getId(), studentSave.getName());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> getAllStudents() {

        List<Student> getStudents = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for(Student student:getStudents) {

            StudentDTO studentDTO = new StudentDTO(
                    student.getId(),
                    student.getName()
            );

            studentDTOList.add(studentDTO);
        }

        return studentDTOList;

    }

    @Override
    @Transactional(readOnly = true)
    public StudentDetailsDTO getStudentDetails(Integer id) {

        Optional<Student> studentOptional = studentRepository.findById(id);
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        if (studentOptional.isPresent()) {

            Student student = studentOptional.get();
            List<StudentTeacher> studentTeachersList = student.getStudentTeachers();

            for (StudentTeacher studentTeacher:studentTeachersList) {

                Teacher teacher = studentTeacher.getTeacher();

                TeacherDTO teacherDTO = new TeacherDTO(
                        teacher.getId(),
                        teacher.getName()
                );

                teacherDTOList.add(teacherDTO);
            }

            StudentDetailsDTO studentDetailsDTO = new StudentDetailsDTO();
            studentDetailsDTO.setId(student.getId());
            studentDetailsDTO.setName(student.getName());
            studentDetailsDTO.setTeachers(teacherDTOList);

            return studentDetailsDTO;
        }

        else {
            throw new RuntimeException("Student ID: " + id + " Not Found !!!");
        }
    }
}
