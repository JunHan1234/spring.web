package com.my.spring.web.ch02.ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex03")
@RequestMapping("ch02/ex03/user")
public class UserController {
	//이 핸들러의 url은 get방식의 ch02/ex03/user이다.
	/*//핸들러의 url을 다른 방식(ch01)으로 구현해보았다.
	@GetMapping
	public String userIn() {
		//form을 return
		return "ch02/ex03/userIn";
	}
	*/
	
	//이 핸들러의 url은 post방식의 ch02/ex03/user이다.
	//@PostMapping
	public String userOut(User user) {
		return "ch02/ex03/userOut";
	}
}
