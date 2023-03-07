package com.my.spring.web.ch02.ex02;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Bean의 이름이 userController로 중복되므로 수동 설정해준다.
@Controller("ch02.ex02")
//request mapping으로 handler의 공통 url을 지정한다.
@RequestMapping("ch02/ex02")
public class UserController {
	@GetMapping("userIn")
	//string을 return받는 handler 활용.
	public String userIn() {
		return "ch02/ex02/userIn";
	}
	
	//submit 버튼으로 request를 받은 userOut.
	//Mapping 방식을 Post로 받는다.
	/*
					@PostMapping("userOut") //request parameter를 userOut의 parameter로 읽고 받는다.
					public String userOut(@RequestParam String username, //parameter가 int로
					자동변환된다.(spring의 장점)
					
						@RequestParam int age, //LocalDate는 복잡하기에 자동변환 안된다. 따라서 client의 날짜형식을 기술해서
						자동변환 시킨다.
						@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate, Model
						model) {
		model.addAttribute("user", new User(username, age, regDate));
		return "ch02/ex02/userOut";
	}
	 */
	@PostMapping("userOut")//@RequestParam은 default값이므로 생략가능하다.
	public String userOut(String username,
						int age,
						@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate,
						Model model) {
		model.addAttribute("user", new User(username, age, regDate));
		return "ch02/ex02/userOut";
	}
}
