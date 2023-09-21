package com.aws.spring_study;

import com.aws.spring_study.ioc_di.TestController;
import com.aws.spring_study.ioc_di.TestService1;
import com.aws.spring_study.ioc_di.TestService2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);
//		main2();
	}

	public static void main2() {
		TestService2 testService2 = new TestService2();
		TestService1 testService1 = new TestService1();
		TestController testController = new TestController(testService1);
		testController.controll();
	}

}

