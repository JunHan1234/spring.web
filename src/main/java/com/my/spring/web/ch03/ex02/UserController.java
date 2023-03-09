package com.my.spring.web.ch03.ex02;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Controller("ch03.ex02")
@RequestMapping("ch03/ex02/user")
public class UserController {
	@Value("${attachPath}") private String attachPath;
	
	@GetMapping
	public String userIn() {
		return "ch03/ex02/userIn";
	}
	
	@PostMapping
	public String userOut(UserDto userDto, HttpServletRequest request, User user) {
		//Original 은 client가 사용한 것을 뜻한다. (이름의 중복을 막기 위함.)
		String filename = userDto.getFace().getOriginalFilename();
		//saveFile method와 userDto를 이용해 사진파일을 저장.
		saveFile(attachPath + "/" + filename, userDto.getFace());
		
		//사진 파일명을 저장.
		user.setFaceFilename(filename);
		
		return "ch03/ex02/userOut";
	}
	
	private void saveFile(String filename, MultipartFile file) {
		try {
			//file 객체 생성. data는 없는 순수한 객체.
			file.transferTo(new File(filename));
		} catch(IOException e) {}
	}
}
