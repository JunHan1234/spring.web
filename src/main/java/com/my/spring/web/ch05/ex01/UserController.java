package com.my.spring.web.ch05.ex01;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.spring.web.ch05.domain.User;

//Rest 형태로 작동하게 하기 위한 특별한 controller annotation.
//Rest 형태는 json으로 할 예정.
@RestController("ch05.ex01")
@RequestMapping("ch05/ex01")
public class UserController {
	@GetMapping("main")
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("ch05/ex01/main");
		return mv; //dispatcher에게 return.
	}
	
	//Get button을 눌러서 생긴 queryString이 더해진 url을 이 핸들러로 받는다.
	@GetMapping("list")//get은 읽기.
	//jackson library가 json으로 user를 변환 후 return 에 담아준다.
	public User get(User user) {
		return user;
	}
	
	//Post button을 눌러서 request body안의 json data를 가져와서 User에 담는다.
	@PostMapping("post")//post는 추가.
	//json 형태의 command를 받아야한다.
	//Post방식이므로 requestbody안의 json data를 user라는 command에 담는다.
	public User post(@RequestBody User user) {
		return user;
	}
	
	@PutMapping("put")//put은 수정.
	public User put(@RequestBody User user) {
		return user;
	}
	
	@PatchMapping("patch")//patch도 수정.
	public User patch(@RequestBody User user) {
		return user;
	}
	
	@DeleteMapping("delete")//delete는 삭제.
	public User delete(@RequestBody User user) {
		return user;
	}
}
