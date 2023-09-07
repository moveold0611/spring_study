package com.aws.spring_study.controller;


import com.aws.spring_study.dto.JsonTestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RespStudyController {

    @GetMapping("/resp/str")
    public String strTest() {
        return "문자열하나열둘열셋열넷";
    }

    @GetMapping("/resp/obj")
    public Object objectTest() {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("name", "aaa");
        return responseMap; // Json으로 자동 변환해서 응답
    }

    @GetMapping("/resp/obj2")
    public Object objectTest2() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        return jsonTestDto; // Json으로 자동 변환해서 응답
    }

    @GetMapping("/resp/status")
    public Object statusTest(HttpServletResponse response) {
        response.setStatus(400);
        return null;
    }
    @GetMapping("/resp/resp-entity")
    public ResponseEntity<?> responseEntityTest() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400
    } // 400번대 오류는 웹 개발자 도구의 네트워크 항목을 볼 것

    @GetMapping("/resp/resp-entity2")
    public ResponseEntity<?> responseEntityTest2() {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // 401
    }

    @GetMapping("/resp/resp-entity3")
    public ResponseEntity<?> responseEntityTest3() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("aaa");
        jsonTestDto.setAge(111);
        return new ResponseEntity<JsonTestDto>(jsonTestDto, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/resp/resp-entity4")
    public ResponseEntity<Map<String, Object>> mapResponseEntity() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "데이터");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/resp/resp-entity5")
    public ResponseEntity<JsonTestDto> jsonResponse() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("aaa");
        jsonTestDto.setAge(111);
        return ResponseEntity.ok().body(jsonTestDto);
    }

    @GetMapping("/resp")
    public ResponseEntity<JsonTestDto> finallresponse() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("final");
        jsonTestDto.setAge(999);
        return ResponseEntity.status(200).body(jsonTestDto);
    }


}
