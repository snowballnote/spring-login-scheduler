package com.example.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableScheduling
@SpringBootApplication
public class ScheduleApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}
	
	// Context 외부저장소를 내부URL 매핑
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.URL패턴.실제저장소위치
		registry.addResourceHandler("/upload/**").addResourceLocations("file:/d:/app/upload");
	}
}