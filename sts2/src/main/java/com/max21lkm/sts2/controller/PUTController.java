package com.max21lkm.sts2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max21lkm.sts2.domain.MemberDTO;

@RestController
//클래스에 설정하면 모든 요청에 공통된 URL
@RequestMapping("/api/v1/put-api")
public class PUTController {
	@PutMapping(value="/member")
	public String postMemberDTO(
			@RequestBody MemberDTO memberDTO) {
		return memberDTO.toString();
	}
	
	//DTO 인스턴스를 리턴하면 JSON 형식으로 출력
	@PutMapping(value="/member1")
	public MemberDTO postMemberDTO1(
			@RequestBody MemberDTO memberDTO) {
		return memberDTO;
	}
	
	@PutMapping(value="/member2")
	public ResponseEntity<MemberDTO> postMemberDTO2(
			@RequestBody MemberDTO memberDTO) {
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(memberDTO);
	}
}
