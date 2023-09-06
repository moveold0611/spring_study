package com.aws.spring_study.controller;

import com.aws.spring_study.dto.ParamsTestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @GetMapping("/get/params/1")
    public Object paramsTest1(@RequestParam String name,@RequestParam Integer age) {
        // @RequsetParam("")은 변수명과 param이 같은 이름이면 생략 가능
        // @RequsetParam을 명시할 시 필수값이 된다(null, 값 없는 요청 불가)
        System.out.println(name);
        System.out.println(age);
        return null;
    }

    @GetMapping("/get/params/11")
    public Object paramsTest11(String name,Integer age) {
        // @RequsetParam("")은 변수명과 param이 같은 이름이면 생략 가능
        // @RequsetParam 생략 시 null, 값 없는 요청 가능
        System.out.println(name);
        System.out.println(age);
        return null;
    }

    @GetMapping("/get/params/2")
    public Object paramsTest2(ParamsTestDto paramsTestDto) {
        System.out.println(paramsTestDto);
        return null;
    }

    @GetMapping("/get/{id}")
    public Object pathVariable(@PathVariable("id") int id) {
        System.out.println(id);
        return null;
    }
}
