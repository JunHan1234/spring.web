package com.my.spring.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Value("${attachPath}")
	private String attachPath;
	
	@Override
	//view만 return.
	//일반 컨트롤러가 아닌 View Controller에 url을 mapping. 2순위로 사용할 방법이다.
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ch01/main");
		registry.addViewController(
				/*contextpass 이후의 url을 적는다.*/
				"ch02/ex03/user").setViewName("ch02/ex03/userIn");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//**은 0개 이상을 뜻한다.
		//현재 이 [resource handler]가 [dispatcher servlet]이 던져준 주소를 받아 해석한다.
		//context-path는 제외하고 그 아래가 res/**로 시작한다면, [resource handler]가 동작하고,
		//처리 후, [tomcat]이 갖고있는 [default servlet] 객체에 response를 보낸다.
		registry.addResourceHandler("res/**").addResourceLocations("WEB-INF/res/");
		//attach 폴더는 app이 아니라 window상 파일이므로, 경로를 file로 시작하게 적는다.
		registry.addResourceHandler("attach/**").addResourceLocations("file:///" + attachPath + "/");
	}
}
