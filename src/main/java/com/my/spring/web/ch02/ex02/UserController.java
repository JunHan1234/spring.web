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
	public String userOut(@RequestParam String username,
					//parameter가 int로 자동변환된다.(spring @의 장점)
					@RequestParam int age,
					//LocalDate는 복잡하기에 자동변환 안된다.
					// 이는 client마다 parameter로 던지는 string 형식이 다르기 때문이다.
					//따라서 client의 날짜형식을 기술해줘서 자동변환 시킨다.(크롬의 date패턴으로 적었다.)
					@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate,
					Model model) {
		model.addAttribute("user", new User(username, age, regDate));
		return "ch02/ex02/userOut";
	}
	*/
	@PostMapping("userOut")
	//client에서 parameter로 던진 data를 받을 핸들러의 파라미터 형식에서,
	// @RequestParam은 default값이므로 생략가능하다.
	// 하지만, 평범하지 않은 패턴(리스트라던지)이면, 적어줘야 인식한다.
	public String userOut(String username,
						int age,
						@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate,
						Model model) {
		model.addAttribute("user", new User(username, age, regDate));
		return "ch02/ex02/userOut";
	}
}
