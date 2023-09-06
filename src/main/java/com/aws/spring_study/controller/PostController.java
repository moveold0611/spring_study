package com.aws.spring_study.controller;

import com.aws.spring_study.dto.JsonTestDto;
import com.aws.spring_study.dto.xWwwTestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/post/xwww")
    public Object xWwwUrlFormEncoded(xWwwTestDto xWwwTestDto) {
        System.out.println(xWwwTestDto);
        return null;
    }

    @PostMapping("/post/json")
    public Object json(@RequestBody JsonTestDto jsonTestDto) {
        // json은 @RequestBody가 필수적으로 있어야 한다.
        System.out.println(jsonTestDto);
        return null;
    }
}
