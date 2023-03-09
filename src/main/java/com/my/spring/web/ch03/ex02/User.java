package com.my.spring.web.ch03.ex02;

import lombok.Data;

@Data
public class User {
	private String username;
	private int age;
	//사진파일명 받아들일 준비.
	private String faceFilename;
}
