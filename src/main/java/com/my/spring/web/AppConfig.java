package com.my.spring.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Override
	//view만 return.
	//일반 컨트롤러가 아닌 View Controller에 url을 mapping. 2순위로 사용할 방법이다.
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ch01/main");
		registry.addViewController(
				/*contextpass 이후의 url을 적는다.*/
				"ch02/ex03/user").setViewName("ch02/ex03/userIn");
	}
}
