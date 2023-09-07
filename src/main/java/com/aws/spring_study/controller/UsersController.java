package com.aws.spring_study.controller;

import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.repository.UserMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private UserMappers userMappers;

    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserReqDto registerUserReqDto) {
        Integer count = userMappers.saveUser(registerUserReqDto);
        return ResponseEntity.ok().body(count);
    };

    @CrossOrigin
    @PutMapping("/user")
    public ResponseEntity<?> modificationUser(@RequestBody RegisterUserReqDto registerUserReqDto) {
        Integer count = userMappers.saveUser(registerUserReqDto);
        return ResponseEntity.ok().body(count);
    };

    @CrossOrigin
    @DeleteMapping("/user")
    public ResponseEntity<?> removeUser(@RequestBody RegisterUserReqDto registerUserReqDto) {
        Integer count = userMappers.saveUser(registerUserReqDto);
        return ResponseEntity.ok().body(count);
    };
}
