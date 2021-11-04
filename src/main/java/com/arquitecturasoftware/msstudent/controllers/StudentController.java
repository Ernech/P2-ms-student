package com.arquitecturasoftware.msstudent.controllers;

import com.arquitecturasoftware.msstudent.entities.Student;
import com.arquitecturasoftware.msstudent.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/student")
public class StudentController {


    StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping(path = "/all")
    public List<Student> getAllStudents(){
        return studentService.listAllStudents();
    }

    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable(value = "id") Integer id) throws Exception{

        Optional<Student> studentOptional = studentService.findStudentById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }else{
            throw new Exception("Estudiante no encontrado");
        }

    }




}
