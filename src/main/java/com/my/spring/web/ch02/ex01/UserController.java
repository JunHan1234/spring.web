package com.my.spring.web.ch02.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//IoC, Handler 등록을 위해 @Controller 를 붙인다.
@Controller
public class UserController { //controller준비.
	//@GetMapping(request method가 GET이다.)으로 context-path의
	//주소 이후를 설정해서 handler의 Mapping을 해준다.
	@GetMapping("11")
	//spring container가 model view를 담을 그릇을 만들어준다.
	public ModelAndView handler11(ModelAndView mv) {
		//model은 service로부터 오고, service는 이 model을 dao로부터 받고 dao는 이 data를 DB(oracle)에서 받는다.
		mv.addObject("user", new User("최한석", 11)); //model준비.
		mv.setViewName("ch02/ex01/user"); //view준비.
		
		return mv; //mv 객체를 dispatcher servlet에게 return.
	}//mvc의 준비 완료.
	
	@GetMapping("21")
	public String handler21(Model model) { //model을 담을 그릇 준비.
		model.addAttribute("user", new User("한아름", 21)); //model준비.
		return "ch02/ex01/user"; //view name을 return(view의 준비). model도 알아서 dispatcher에게 던져준다.
	}
	
	@GetMapping("22")
	public String handler22() {
		return "ch02/ex01/user"; //view만 return.
	}
}
