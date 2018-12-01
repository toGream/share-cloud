package org.share.topic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class TopicApplication {
	public static void main(String[] args) {
		SpringApplication.run(TopicApplication.class, args);
	}
	
	@GetMapping("hello")
	public String sayHello() {
		return "HelloWorld!";
	}
	
	@Value("${foo}")
	String str;
	@GetMapping("hi")
	public String sayHi() {
		return "Hi, " + str;
	}
}
