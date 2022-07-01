package com.example.eschool.controllers;

import com.example.eschool.mappers.StudentMapper;
import com.example.eschool.mappers.UserMapper;
import com.example.eschool.models.Student;
import com.example.eschool.models.User;
import com.example.eschool.utils.OrdinaryResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserMapper userMapper;
    private StudentMapper studentMapper;

    public UserController(UserMapper userMapper, StudentMapper studentMapper) {
        this.userMapper = userMapper;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public List<User> getUsers(){
        List<User> users = userMapper.findAll();
        if(users.size() > 0){
            for(int i = 0; i < users.size(); i++){
                List<Student> students = studentMapper.findAllFromCurator(i);
                users.get(i).setStudents(students) ;
            }
        }
        return users;
    }

    @GetMapping("/{id}")
    public List<Student> getStudents(@PathVariable int id){
        List<Student> students = studentMapper.findAllFromCurator(id);
        return students;
    }
    @PostMapping(value="/check",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<OrdinaryResponse> checkIfUserExists(@RequestBody User data){
        String username = data.getUsername();
        String password = data.getPassword();
        User user = userMapper.findByNameAndPassword(username, password);
        user.setStudents(this.studentMapper.findAllFromCurator(user.getId()));
        return ResponseEntity.ok(new OrdinaryResponse(user!=null, user));


    }
}
