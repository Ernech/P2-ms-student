package com.arquitecturasoftware.msstudent.repositories;

import com.arquitecturasoftware.msstudent.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {


}
