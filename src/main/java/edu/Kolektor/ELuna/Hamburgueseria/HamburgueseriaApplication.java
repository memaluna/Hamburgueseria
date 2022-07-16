package edu.Kolektor.ELuna.Hamburgueseria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class HamburgueseriaApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HamburgueseriaApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(HamburgueseriaApplication.class, args);
	}

}
