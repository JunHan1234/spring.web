package com.my.spring.web.ch02.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ch02/home")
public class NumController {
	@GetMapping("numIn")
	public String numIn() {
		return "ch02/home/numIn";
	}
	
	@PostMapping("numOut")
	public String numOut(@ModelAttribute("myNumber") NumDto myNumber,
						@RequestParam("userNum") int userNum) {
		double comNum = (int)(Math.random() * 10) / 10.0;
		
		myNumber.setResultNum(userNum + comNum);
		
		return "ch02/home/numOut";
	}
}
/*
폼에 자연수 하나를 입력한다.
폼을 제출한다.
입력값 <= x < 입력값 + 1인, x 를 출력한다.
x는 실수이다.
x는 랜덤값이다.
x는 소수점 이하 한자리까지 표현한다.
*/