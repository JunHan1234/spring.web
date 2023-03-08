package com.my.spring.web.ch02.ex04;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ch02/ex04")
public class CheckController {
	@GetMapping("main")
	public String main() {
		return "ch02/ex04/main";
	}
	
	@GetMapping("choice")
	public String choice(int kind) {
		System.out.println("choice");
		String view = "ch02/ex04/";
		
		switch(kind) {
		case 1: view += "radioIn"; break;
		case 2: view += "checkboxIn";
		}
		
		return view;
	}
	/*
	@PostMapping("radio")
	public String radio(String agree, Model model) {
		model.addAttribute("agree", agree);
		return "ch02/ex04/radioOut";
	}
	*/
	@PostMapping("radio") //@ModelAttribute를 붙여 모델로 변환.
	public String radio(@ModelAttribute("agree") String agree) {
		return "ch02/ex04/radioOut";
	}
	
	/*
	//parameter value가 배열인 상황.
	@PostMapping("checkbox")
	//parameter name과 변수명이 불일치 할때는,
	//@RequestParam에 parameter name을 직접 기술해줄 수 있다.
	public String checkbox(@RequestParam("fruit") ArrayList<String> fruits) {
		return "ch02/ex04/checkboxOut";
	}
	*/
	@PostMapping("checkbox")//RequestParam과 ModelAttribute 둘다 사용해야하는 경우는,
							// 한 쪽이 무시되기때문에, Model 객체를 따로 이용한다.
	public String checkbox(@RequestParam("fruit") ArrayList<String> fruits, Model model) {
		model.addAttribute("fruits", fruits);
		return "ch02/ex04/checkboxOut";
	}
}
