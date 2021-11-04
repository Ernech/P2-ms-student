package com.arquitecturasoftware.msstudent.services;

import com.arquitecturasoftware.msstudent.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    Student saveStudent(Student student);

    List<Student> listAllStudents();

    Optional<Student> findStudentById(Integer id);

}
