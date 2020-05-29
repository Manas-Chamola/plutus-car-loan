package com.lti.plutusloan;

import java.io.File;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.lti.plutusloan.controller.FileUploadController;

@SpringBootApplication
@ComponentScan("com.lti")
@EntityScan("com.lti")
@EnableJpaAuditing
public class PlutusCarLoanApplication {

	public static void main(String[] args) {
		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(PlutusCarLoanApplication.class, args);
	}

}
