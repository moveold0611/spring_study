package com.aws.spring_study.controller;


import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.entity.User;
import com.aws.spring_study.repository.UserMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {

//    @Autowired // IOC
//    @Qualifier("service1") // 명시 가능한 Autowired
    private final UserMappers userMappers;

    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<Integer> registerUser(@RequestBody RegisterUserReqDto registerUserReqDto) {
        boolean flag = false;
        for (int i = 0; i < userMappers.getUserListAll().size(); i++) {
            if(registerUserReqDto.getUsername()
                    .equals(userMappers.getUserListAll().get(i).getUsername())) {
                flag = true;
            }
        }
        if(!flag) {
            Integer count = userMappers.saveUser(registerUserReqDto);
            return ResponseEntity.ok().body(count);
        }else {
            return ResponseEntity.status(404).body(0);
        }
    };

    @CrossOrigin
    @PutMapping("/users/{userId}")
    public ResponseEntity<Integer> modifyUser(@PathVariable int userId, @RequestBody User user) {
        Integer count = userMappers.updateUser(user);
        return ResponseEntity.ok().body(count);
    };

    @CrossOrigin
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Integer> removeUser(@PathVariable int userId, User user) {
        boolean flag = false;
        for (int i = 0; i < userMappers.getUserListAll().size(); i++) {
            if(user.equals(userMappers.getUserListAll().get(i))) {
                flag = true;
                break;
            }
        }
        if(flag){
            Integer count = userMappers.deleteUser(userId);
            return ResponseEntity.ok().body(count);
        }else
            return ResponseEntity.status(404).body(0);

    }

    @CrossOrigin
    @GetMapping("/user/list")
    public ResponseEntity<List<User>> userListAll() {
        return ResponseEntity.ok().body(userMappers.getUserListAll());
    }
}
