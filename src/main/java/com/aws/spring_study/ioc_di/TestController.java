package com.aws.spring_study.ioc_di;

public class TestController {
    private TestService t;

    public TestController(TestService t) {
        this.t = t;
    }

    public void controll() {
        t.aaa();
    }

}
