package com.InternalAssessment.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		Util.loadMessages();
		SpringApplication.run(BlogApplication.class, args);
	}

}
