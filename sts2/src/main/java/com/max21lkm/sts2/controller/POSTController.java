package com.max21lkm.sts2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max21lkm.sts2.domain.MemberDTO;

@RestController
//클래스에 설정하면 모든 요청에 공통된 URL
@RequestMapping("/api/v1/post-api")
public class POSTController {
	
	//POST 방식에서 파라미터 매핑을 할 때는 @RequestBody를 이용
	@PostMapping(value="/member")
	public String postMemberDTO(
			@RequestBody MemberDTO memberDTO) {
		return memberDTO.toString();
	}
	
}
