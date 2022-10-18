package com.max21lkm.sts2.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.max21lkm.sts2.domain.MemberDTO;

@RestController
//클래스에 설정하면 모든 요청에 공통된 URL
@RequestMapping("api/v1/get-api")
public class GETController {
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String getHello() {
		return "Hello GET";
	}
	
	//요청:http://localhost:8080/api/v1/get-api/variable/문자열
	@GetMapping(value="/variable/{variable}")
	//{} 의 변수와 String 다음의 변수명이 일치해야 함
	
	//public String getVariable(@PathVariable String variable) 
	public String getVariable(
			@PathVariable("variable") 
			String var)
	
	{
		return var;
	}
	
	//파라미터 처리 (제일 고전적인 방법)
	@GetMapping(value="/parameter1")
	public String parameter1(
			HttpServletRequest request) {
		String result = request.getParameter("email")
				+ " " + request.getParameter("name")
				+ " " + request.getParameter("organization");
		return result;
	}
	
	//파라미터 처리의 두 번째 방법(위의 방법과 다른 점은 String 대신 다른 자료형을 쓸 수 있다는 점)
	//파라미터를 읽어서 형 변환까지 수행
	@GetMapping(value="/parameter2")
	public String parameter2(
			@RequestParam("email") String email,
			@RequestParam("name") String name,
			@RequestParam("organization") String organization) {
		String result = email + " " + name + " " + organization;
		return result;
	}
	
	//파라미터가 어떻게 올지 몰라서 Map을 이용
	@GetMapping(value="/parameter3")
	public String parameter3(
			@RequestParam Map<String, String> param) {
		StringBuilder result = new StringBuilder();
		
		//Map 순환
		//이름을 모를 때 사용, 권장하는 방식은 아님
		param.entrySet().forEach(map -> {
			result.append(map.getKey() + ":" + 
					map.getValue() + "\n");
		});
		
		return result.toString();
	}
	
	//파라미터들을 하나의 인스턴스로 묶어서 처리
	//파라미터가 여러 개 일 때 권장하는 방식
	@GetMapping(value="/parameter4")
	public String parameter4(
			MemberDTO memberDTO) {
		return memberDTO.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
