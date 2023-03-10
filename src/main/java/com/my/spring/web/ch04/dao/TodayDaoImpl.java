package com.my.spring.web.ch04.dao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.spring.web.ch04.dao.map.TodayMap;

//persistence layer임을 나타내는 IoC annotation.
@Repository
public class TodayDaoImpl implements TodayDao {
	@Autowired private TodayMap todayMap;
	
	@Override
	public LocalDate selectToday() {
		return todayMap.selectToday();
	}
}
