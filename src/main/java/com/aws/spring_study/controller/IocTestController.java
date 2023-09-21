package com.aws.spring_study.controller;

import com.aws.spring_study.service.IocTestService1;
import com.aws.spring_study.service.IocTestService2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Component의 종류
    1. 요청, 응답 -> @Controller(ssr) -> RestFull한 Controller -> ResController
    2. 비지니스 로직(Controller와 Resposiroty(DB) 사이에서 처리되는 로직) -> @Service()
    3. DB -> @Repository -> DAO -> Mybatis(@Mapper)
    4. 설정, 2개 이상의 Bean등록 -> @Configulation
    5. 기타 Ioc 객체 -> @Component
 */

@RestController
@RequiredArgsConstructor
public class IocTestController {

    private final IocTestService1 iocTestService1;
    private final IocTestService2 iocTestService2;

//    public IocTestController() {
//        iocTestService1 = new IocTestService1();
//        iocTestService2 = new IocTestService2();
//    }

    @GetMapping("/ioc/test")
    public ResponseEntity<?> testGet() {
        iocTestService1.t1();
        iocTestService2.t2();
        return  ResponseEntity.ok(null);
    }

}
