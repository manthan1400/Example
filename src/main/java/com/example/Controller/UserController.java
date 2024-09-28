package com.example.Controller;

import com.example.Model.Student;
import com.example.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        userService.createStudent(student);
        return ResponseEntity.ok("Student added");
    }


    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll(){
     List<Student> students=userService.getAll();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{stdId}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable int stdId){
        return ResponseEntity.ok(userService.getStudent(stdId));
    }


}

