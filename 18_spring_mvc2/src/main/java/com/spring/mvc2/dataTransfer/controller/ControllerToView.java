package com.spring.mvc2.dataTransfer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc2.dataTransfer.domain.MemberDto;

@Controller
@RequestMapping("cTOv")
public class ControllerToView {

	/*
	 * 
	 *  예시 1) Model
	 *  
	 *  메서드의 파라미터로 Model을 추가하여 addAddtribute("속성명","값") 메서드로 뷰에서 사용할 데이터를 전송 한다.
	 * 
	 * */
	@RequestMapping(value="/modelEx" , method=RequestMethod.GET)
	public String modelEx(Model model) {
		
		MemberDto memberDto;
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		
		for (int i = 1; i < 11; i++) {
			memberDto = new MemberDto();
			memberDto.setId("아이디"+i);
			memberDto.setPassword("1111");
			memberDto.setName("이름" + i);
			memberDto.setEmail("이메일"+ i);
			
			memberList.add(memberDto);
		}
		
		model.addAttribute("method", "Model");
		model.addAttribute("memberList", memberList);
		
		return "dataTransfer/memberList";
	}
	/*
	 * 
	 * 예시 2) ModelAndView
	 * 
	 * ModelAndView객체를 생성하여  addObject("속성명", "값") 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 관용적으로 객체명으로 mv 혹은 mav로 작성한다.
	 * 
	 * */
	
	@RequestMapping(value="/modelAndViewEx" , method=RequestMethod.GET)
	public ModelAndView modelAndViewEx() {	// return 타입은 String이 아닌 ModelAndView 클래스 
		
		// ModelAndView mv = new ModelAndView();		// ModelAndView 객체 생성
		// mv.setViewName("dataTransfer/memberList"); //(jsp파일명) setViewName()메서드로 포워딩할 jsp파일 명시
		
		// setViewName메서드 대신 생성자의 인수로 포워딩할 jsp파일 명시
		ModelAndView mv = new ModelAndView("dataTransfer/memberList");		
		
		
		MemberDto memberDto;
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		
		for (int i = 11; i < 21; i++) {
			memberDto = new MemberDto();
			memberDto.setId("아이디"+i);
			memberDto.setPassword("1111");
			memberDto.setName("이름" + i);
			memberDto.setEmail("이메일"+ i);
			
			memberList.add(memberDto);
		}
		
		// .addObject(속성명, 값) 메서드로 뷰에서 사용할 데이터를 전송
		mv.addObject("method" , "ModelAndView");
		mv.addObject("memberList" , memberList);
		
		return mv; // ModelAndView 객체를 반환
	}
	
	/*
	 * 
	 * 예시 3) httpServletRequest
	 * 
	 * HttpServletRequest객체를 생성하여 setAttribute("속성명", "값") 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 
	 * */
	@RequestMapping(value="/requestEx" , method=RequestMethod.GET)
	public String requestEx(HttpServletRequest request) {
		
		MemberDto memberDto;
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		
		for (int i = 21; i < 31; i++) {
			memberDto = new MemberDto();
			memberDto.setId("아이디"+i);
			memberDto.setPassword("1111");
			memberDto.setName("이름" + i);
			memberDto.setEmail("이메일"+ i);
			
			memberList.add(memberDto);
		}
		
		request.setAttribute("method", "request");
		request.setAttribute("memberList", memberList);	
		
		return "dataTransfer/memberList";
	}
	/*
	  
	 	# 예시 4) ResponseBody  
	 	
	 	- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 html 본문만 전송한다.
	 	- 한글 데이터가 전송이 되지 않으며 한글 전송시 ResponseEntity의 객체의 
	 	  객체명.add("Content-Type", "text/html; charset=utf-8") 메서드를 이용하여 헤더 정보를 추가하여 사용한다.
	
	 */
	@RequestMapping(value="/responseBodyEx" , method=RequestMethod.GET)
	public @ResponseBody String responseBodyEx() {
		
//		String message = "<script>";
//			   message += "alert('login fail');";
//			   message += "location.href='modelEx'";
//			   message += "</script>";
		String message = "<h2>hahahahahaha</h2>";
		return message;
	}
	
	/*
	  
		 # 예시 5) ResponseEntity
		 
			 - HTTP에서 Request와 Response 동작시 전송되는 정보는 크게 body(몸체) , headers(헤더), status code(상태 코드)가 있다.
			 - @ResponseBody 에는 없는 헤더와 상태코드가 함께 들어간다.
			
			1. body (옵션)
			- HTTP의 request 또는 response가 전송하는 데이터(본문)
			
			2. headers (옵션
			- HTTP의 request 또는 response에 대한 부가적인 정보
			
			3. status code (필수)
			- 클라이언트의 요청이 성공적으로 처리되었는지 상태를 알려주는 것
	
	*/
	
	@RequestMapping(value="/responseEntityEx" , method=RequestMethod.GET)
	public ResponseEntity<Object> responseEntityEx() {
		
		// 1)
		// return new ResponseEntity<Object>(HttpStatus.OK);
		
		// 2)
		// return new ResponseEntity<Object>("<h1>html 페이지 반환</h1>" , HttpStatus.OK);
		
		// 3)
		// return new ResponseEntity<Object>("<h1>html 페이지 반환</h1>" , new HttpHeaders() , HttpStatus.OK);
		
		// 4)
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("Content-Type" , "text/html; charset=UTF-8");
		
		String data ="<h1>html 페이지 반환</h1>";
		return new ResponseEntity<Object>(data , responseHeader , HttpStatus.OK);
	}
		
}
/*
	
		# 예시 6) RestController 이용 
		
		- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 html 본문만 전송한다.
		- 클래스에 @RestController어노테이션을 작성하여 구현한다. 
	
 */

@RestController
class RestControllerEx {
	
	@RequestMapping(value="/restControllerEx" , method=RequestMethod.GET)
	public String restControllerEx() {
		
		String message = "<script>";
		   message += "alert('login fail');";
		   message += "location.href='cTOv/modelEx'";
		   message += "</script>";
		return message;
	}
}










