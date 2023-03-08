package com.my.spring.web.ch02.ex06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller("ch02.ex06")
@RequestMapping("ch02/ex06")
public class UserController {
	@GetMapping("login") //@CookieValue로 username 이라는 쿠키 값이 있는지 찾는다.
						//만약 존재하지 않더라도 (required=false)설정으로 넘어간다.
	public String loginIn(@CookieValue(required=false) String username,
			@ModelAttribute("user") UserDto user) {
		user.setUsername(username);
		return "ch02/ex06/login";
	}
	
	@PostMapping("login")
	//command로 userDto를 넣는다.
	//login.jsp의 form안의 parameter를 모두 받아들인다.
	public String login(@ModelAttribute("user") UserDto user, String rememberMe,
				//login 한 상태를 저장하기 위한 session 객체를 준비한다.
				HttpSession session,
				//cookie 저장을 위한 response객체를 parameter에 넣는다.
				HttpServletResponse response) {
		session.setAttribute("username", user.getUsername());
		
		if(rememberMe != null && rememberMe.equals("on")) {
			Cookie cookie = new Cookie("username", user.getUsername());
			cookie.setMaxAge(5);
			response.addCookie(cookie);
		}
		
		return "ch02/ex06/logout";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
