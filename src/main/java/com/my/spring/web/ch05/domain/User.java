package com.my.spring.web.ch05.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class User {
	private int userId;
	private String username;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//Json으로 변환시 값으로 들어갈 형식을 정한다.
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private LocalDate birthday;
}
