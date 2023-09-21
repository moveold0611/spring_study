package com.aws.spring_study.ioc_di;

public class TestService1 implements TestService{
    @Override
    public void aaa() {
        System.out.println("테스트서비스1에서 호출");
    }
}
