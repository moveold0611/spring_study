package com.aws.spring_study.service;

import org.springframework.stereotype.Service;

@Service
public class IocTestService1 {

    public void t1() {
        System.out.println("테스트 서비스 1 호출");
    }

}
