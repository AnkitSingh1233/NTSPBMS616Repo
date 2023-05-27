package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Component
public class MVCConfigure implements WebMvcConfigurer {

	
	
/*public void configureViewResolvers(ViewResolverRegistry registry) {

InternalResourceViewResolver resolver=new InternalResourceViewResolver();

resolver.setPrefix("/WEB-INF/pages/");
resolver.setSuffix(".jsp");
registry.viewResolver(resolver);
	  
	  
  
  }*/

	
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		  System.out.println("MVCConfigure.configureViewResolvers()");
		  
		  UrlBasedViewResolver resolve=new  UrlBasedViewResolver();
		  resolve.setPrefix("/WEB-INF/pages/");
		  resolve.setSuffix(".jsp");
		  
		  resolve.setViewClass(InternalResourceView.class);
		  //resolve.setViewClass(JstlView.class);
		  
		  registry.viewResolver(resolve);
		
		
		
	}




}
