package com.my.spring.web.ch03.ex02;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDto {
	private String username;
	private int age;
	//client와 handler사이에 주고받는 data.
	//얼굴 사진을 업로드 하기 위한 준비.
	private MultipartFile face;
}
