package com.my.spring.web.ch02.ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex03")
@RequestMapping("ch02/ex03/user")
public class UserController {
	//이 핸들러의 url은 get방식의 ch02/ex03/user이다.
	//핸들러의 url을 다른 방식(ch01)으로 구현해보았다.
	@GetMapping
	public String userIn() {
		//form을 return
		return "ch02/ex03/userIn";
	}
	
	
	//이 핸들러의 url은 post방식의 ch02/ex03/user이다.
	@PostMapping //command: model의 역할, parameter값을 request url로 보내는 역할 두가지 수행하는 것.
	public String userOut(User user) { //container가 호출할때 만드는 User객체는 기본생성자로 만든다.
		return "ch02/ex03/userOut";
	}
}
