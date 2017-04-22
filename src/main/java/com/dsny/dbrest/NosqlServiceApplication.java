package com.dsny.dbrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.dsny.dbrest.controller","com.dsny.dbrest.repository"})
public class NosqlServiceApplication{ 

	@Autowired
	SummaryRepository baseRepository;
	@Autowired
	
	public static void main(String[] args) {
		
		SpringApplication.run(NosqlServiceApplication.class, args);
	}
}
