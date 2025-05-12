package com.example.SpringbootRestAPIproject.repository;

import com.example.SpringbootRestAPIproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer> {
}
