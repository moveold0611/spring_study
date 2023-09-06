package com.aws.spring_study.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
// RestController Data만 리턴 가능 (CSR에 무조거 필요)
// Controller Data를 리턴 또는 html(view)을 리턴 가능 (SSR가능)
public class ReqStudyController {


    @GetMapping("/test/get")
    public Object get() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("name", "이동헌");
        dataMap.put("email", "aaa@gmai");
        return dataMap;
    }

    @PostMapping("/test/post")
    public Object post() {
        return "POST";
    }

    @PutMapping("/test/put")
    public Object put() {
        return "PUT";
    }

    @DeleteMapping("/test/delete")
        public Object delete() {
        return "DELETE0";
    }



}
