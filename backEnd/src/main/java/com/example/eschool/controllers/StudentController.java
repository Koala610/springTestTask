package com.example.eschool.controllers;

import com.example.eschool.mappers.StudentMapper;
import com.example.eschool.mappers.UserMapper;
import com.example.eschool.models.Student;
import com.example.eschool.utils.ErrorResponse;
import com.example.eschool.utils.OrdinaryResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentMapper studentMapper;
    private UserMapper userMapper;

    public StudentController(StudentMapper studentMapper, UserMapper userMapper){
        this.studentMapper = studentMapper;
        this.userMapper = userMapper;
    }

    @GetMapping
    List<Student> getStudents(){
        List<Student> students= this.studentMapper.findAll();
        return students;

    }

    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity addStudent(@RequestBody Student student){
        if(userMapper.findById(student.getCuratorId())==null){
            return new ResponseEntity<ErrorResponse>(new ErrorResponse("No such curator"), HttpStatus.BAD_REQUEST);
        }
        this.studentMapper.insert(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteStudent(@PathVariable int id){
        if(studentMapper.findById(id)==null){
            return new ResponseEntity<ErrorResponse>(new ErrorResponse("No such student"), HttpStatus.BAD_REQUEST);
        }
        this.studentMapper.deleteById(id);
        return new ResponseEntity<OrdinaryResponse>(new OrdinaryResponse("Done"), HttpStatus.OK);

    }
}
