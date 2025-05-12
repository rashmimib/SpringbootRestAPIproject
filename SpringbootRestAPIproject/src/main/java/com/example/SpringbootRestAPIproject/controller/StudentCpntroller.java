package com.example.SpringbootRestAPIproject.controller;

import com.example.SpringbootRestAPIproject.entity.Student;
import com.example.SpringbootRestAPIproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentCpntroller {

    @Autowired
    StudentRepository repo;
    //get all the students
    //localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudent(){

        List<Student> students = repo.findAll();
        return students;
    }

    //localhost:8080/studnts/id
    @GetMapping("students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();

        return student;
    }

    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        repo.save(student);
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudents(@PathVariable int id){
        Student student = repo.findById(id).get();
        student.setName("xyz");
        student.setPercentage(99);
        repo.save(student);
        return student;
    }

    @DeleteMapping("/student/delete/{id}")
    public void removeStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        repo.delete(student);
    }
}
