package com.aws.spring_study.ioc_di;

public class TestService2 implements TestService{
    @Override
    public void aaa() {
        System.out.println("테스트서비스2에서 호출");
    }
}
