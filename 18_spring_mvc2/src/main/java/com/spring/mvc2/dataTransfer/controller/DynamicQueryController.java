package com.spring.mvc2.dataTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc2.dataTransfer.dao.DynamicQueryDao;
import com.spring.mvc2.dataTransfer.domain.OrderDto;

@Controller
@RequestMapping("dynamicQuery")
public class DynamicQueryController {

	@Autowired
	private DynamicQueryDao dynamicQueryDao;
	
	@RequestMapping(value="/ifEx", method=RequestMethod.GET)
	public String ifEx() {
		
		OrderDto orderDto = new OrderDto();
		// 주석 해지 및 적용으로 값을 바꾸어가면서 확인
		// orderDto.setProductCode("1111");
		orderDto.setProductName("테스트상품명1");
		orderDto.setProductPrice(10000);
		orderDto.setOrderCount(3);
		orderDto.setTotalPrice(30000);
		
		dynamicQueryDao.ifEx(orderDto);
		
		return "home";
	}
	
	@RequestMapping(value="/chooseEx" , method=RequestMethod.GET)
	public String chooseEx() {
		OrderDto orderDto = new OrderDto();
		orderDto.setProductCode("0x001"); // 0x001, 0x002, 0x003, 0x004 로 바꾸면서 확인 
		orderDto.setOrderCount(3);
		
		dynamicQueryDao.chooseEx(orderDto);
		return "home";
	}
	
}
