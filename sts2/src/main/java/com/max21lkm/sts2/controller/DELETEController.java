package com.max21lkm.sts2.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//클래스에 설정하면 모든 요청에 공통된 URL
@RequestMapping("/api/v1/delete-api")
public class DELETEController {
	@DeleteMapping(value="/request")
	public String member(
			@RequestParam("email") String email) {
		return email;
	}
}
