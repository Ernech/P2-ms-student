package com.arquitecturasoftware.msstudent.services;

import com.arquitecturasoftware.msstudent.entities.Student;
import com.arquitecturasoftware.msstudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    StudentRepository studentRepository;


    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findStudentById(Integer id) {
        return studentRepository.findById(id);
    }
}
