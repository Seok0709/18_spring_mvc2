package com.spring.mvc2.dataTransfer.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.dataTransfer.domain.OrderDto;

@Repository
public class DynamicQueryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void ifEx(OrderDto orderDto) {
		sqlSession.insert("dynamicQuery.ifEx", orderDto);
	}
	
	public void chooseEx(OrderDto orderDto) {
		sqlSession.insert("dynamicQuery.chooseEx" , orderDto);
	}
}
