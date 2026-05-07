package com.antra.homework2.service.IMPL;

import com.antra.homework2.dto.TeacherDTO;
import com.antra.homework2.entity.Teacher;
import com.antra.homework2.repo.TeacherRepository;
import com.antra.homework2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    @Transactional
    public TeacherDTO addTeacher(TeacherDTO teacherDTO) {

        Teacher teacher = new Teacher(
                teacherDTO.getName()
        );

        Teacher teacherSave = teacherRepository.save(teacher);
        return new TeacherDTO(teacherSave.getId(), teacherSave.getName());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeacherDTO> getAllTeachers() {

        List<Teacher> getTeachers = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        for (Teacher teacher:getTeachers) {

            TeacherDTO teacherDTO = new TeacherDTO(
                    teacher.getId(),
                    teacher.getName()
            );

            teacherDTOList.add(teacherDTO);
        }

        return  teacherDTOList;
    }
}

