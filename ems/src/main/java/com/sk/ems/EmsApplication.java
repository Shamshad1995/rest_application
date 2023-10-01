package com.sk.ems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EmsApplication {
	private static final Logger LOGGER= LoggerFactory.getLogger(EmsApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Starting main() in EmsApplication with no arg :: ");
		SpringApplication.run(EmsApplication.class, args);
		LOGGER.info("started main() in EmsApplication successfully :: ");
	}
}
