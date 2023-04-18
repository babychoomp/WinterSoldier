package com.dami.wintersoldier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;


@Configuration
public class WebConfig implements WebMvcConfigurer {  
	// WebConfig.java에서는 WebMvcConfigurer 인터페이스를 구현함으로
	// WebConfig 클래스는 @Configuration 어노테이션을 통해
	// Spring의 MVC의 구성을 변경하거나 확장할 수 있습니다.
	@Bean
	@Description("Thymeleaf template resolver serving HTML")	// 해당 Bean의 설명을 지정합니다.
	ClassLoaderTemplateResolver templateResolver() {
		
		var templateResolver = new ClassLoaderTemplateResolver();
		
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(true);
		templateResolver.setTemplateMode("html");
		templateResolver.setCharacterEncoding("UTF-8");
		
		return templateResolver;
	}
	
	@Bean
	@Description("Thymeleaf template engine with Spring integration")
	SpringTemplateEngine templateEngine() {
		
		var templateEngine = new SpringTemplateEngine();	// Thymeleaf의 템플릿 엔진을 사용하기 위한 Spring 제공 클래스입니다.
		
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.addDialect(new LayoutDialect());
		
		return templateEngine;
	}
	
	@Bean
	@Description("Thymeleaf view resolver")
	ViewResolver viewResolver() {
		
		var viewResolver = new ThymeleafViewResolver();
		
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		
		return viewResolver;
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index.html");
	}
	
}