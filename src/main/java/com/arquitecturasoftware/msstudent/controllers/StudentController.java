package com.arquitecturasoftware.msstudent.controllers;

import com.arquitecturasoftware.msstudent.config.StudentConfig;
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

    StudentConfig studentConfig;

    @Autowired
    public StudentController(StudentServiceImpl studentService, StudentConfig studentConfig) {
        this.studentService = studentService;
        this.studentConfig = studentConfig;
    }

    @GetMapping(path = "test")
    public String testEncrypt(){
        return studentConfig.showConfiguration();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping(path = "/all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Student> getAllStudents(){
        return studentService.listAllStudents();
    }

    @GetMapping(path = "/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public Student getStudentById(@PathVariable(value = "id") Integer id) throws Exception{

        Optional<Student> studentOptional = studentService.findStudentById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }else{
            throw new Exception("Estudiante no encontrado");
        }

    }




}
