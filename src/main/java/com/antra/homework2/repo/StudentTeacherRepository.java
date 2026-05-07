package com.antra.homework2.repo;

import com.antra.homework2.entity.StudentTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTeacherRepository extends JpaRepository<StudentTeacher, Integer> {

}
