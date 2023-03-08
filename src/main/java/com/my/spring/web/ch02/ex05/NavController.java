package com.my.spring.web.ch02.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch02/ex05")
public class NavController {	
	@GetMapping("target")
	public String target() {
		return "ch02/ex05/target";
	}
	
	@GetMapping("forward")
	public String forward() {
		//forward:라는 접두사를 붙이면 viewname으로 인식하는것이 아닌,
		//request url로 인식한다.
		//forward는 서버 내부에서 이동. 여기선 핸들러간에 이동으로 보면됨.
		return "forward:target";
	}
	
	@GetMapping("redirect")
	public String redirect() {
		//response url로 담긴다. 이 response를 client로 보내준다.
		return "redirect:target";
	}
	
	@GetMapping("naver")
	public String naver() {
		return "redirect:https://naver.com";
	}
}
