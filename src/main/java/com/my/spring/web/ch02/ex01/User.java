package com.my.spring.web.ch02.ex01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data는 lombok에서 getter setter를 만들어준다.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String username;
	private int age;
}
