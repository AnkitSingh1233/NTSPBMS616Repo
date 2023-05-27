package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class BootMvcProjMiniProjectCrudOperationApplication {
	
	
	//@Bean
	public InternalResourceViewResolver createUBVR() {
		
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
	
	
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProjMiniProjectCrudOperationApplication.class, args);
	}

}
