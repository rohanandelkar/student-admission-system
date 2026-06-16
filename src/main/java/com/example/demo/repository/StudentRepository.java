package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // INTERVIEW POINT: This is JPQL (Java Persistence Query Language), not standard SQL.
    // It searches for the keyword anywhere in the name, roll number, or section.
    @Query("SELECT s FROM Student s WHERE CONCAT(s.name, ' ', s.rollNumber, ' ', s.section) LIKE %?1%")
    List<Student> search(String keyword);
}