package com.aws.spring_study.controller;

import com.aws.spring_study.dto.RegisterUserReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserReqDto registerUserReqDto) {
        System.out.println(registerUserReqDto);

        return ResponseEntity.ok().body(null);
    };

    @CrossOrigin
    @PutMapping("/user")
    public ResponseEntity<?> modificationUser(@RequestBody RegisterUserReqDto registerUserReqDto) {

        return ResponseEntity.ok().body(null);
    };

    @CrossOrigin
    @DeleteMapping("/user")
    public ResponseEntity<?> removeUser(@RequestBody RegisterUserReqDto registerUserReqDto) {

        return ResponseEntity.ok().body(null);
    };
}
