package com.my.spring.web.ch02.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

//IoC, Handler 등록을 위해 @Controller 를 붙인다.
@Controller
public class UserController { //controller준비.
	//@GetMapping(request method가 GET이다.)으로 context-path의
	//주소 이후를 설정해서 [Handler Mapping]을 해준다.
	@GetMapping("11")
	//spring container가 model view를 담을 그릇을 만들어준다.
	//client의 request를 handler가 받는다.
	//1.[역사순] return type이 ModelAndView 인 경우의 핸들러.
	public ModelAndView handler11(ModelAndView mv) {
		//model은 service로부터 오고, service는 이 model을 dao로부터 받고 dao는 이 data를 DB(oracle)에서 받는다.
		mv.addObject("user", new User("최한석", 11)); //model준비.
		mv.setViewName("ch02/ex01/user"); //view준비.
		
		return mv; //mv 객체를 [Dispatcher Servlet]에게 return.
	}//mvc의 준비 완료.
	
	//2. return type이 string인 경우의 핸들러 2가지.
	@GetMapping("21")
	public String handler21(Model model) { //model을 담을 그릇 준비.
		model.addAttribute("user", new User("한아름", 21)); //model준비.
		return "ch02/ex01/user"; //view name을 return(view의 준비). model도 알아서 dispatcher에게 던져준다.
	}
	
	@GetMapping("22")
	public String handler22() {
		return "ch02/ex01/user"; //view name만 return.
	}
	
	//3. return type이 void인 경우의 핸들러.
	@GetMapping("ch02/ex01/31")
	public void handler31(User user) {
		user.setUsername("양승일");
		user.setAge(31);
		//return값으로 view name이 없는경우,
		//handler가 mapping된 주소(ch02/ex01/31)를 그대로 viewname으로 쓴다.
	}
	
	@GetMapping("ch02/ex01/32")
	//model name을 man으로 지정. (내버려뒀으면 user임)
	public void handler32(@ModelAttribute("man") User user) {
		user.setUsername("서준한");
		user.setAge(32);
	}
	
	//4. return type이 model인 경우의 핸들러.
	@GetMapping("ch02/ex01/41")
	public User handler41(User user) {
		user.setUsername("김가람");
		user.setAge(41);
		
		//model name은 return 이름을 그대로 따서 들어간다.
		return user;
	}
	
	@GetMapping("ch02/ex01/42")
	//return값에 modelname을 수동 할당.
	@ModelAttribute("man")
	public User handler42(User user) {
		user.setUsername("박건우");
		user.setAge(42);
		
		return user;
	}
}
