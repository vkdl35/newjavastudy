package com.max21lkm.sts2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonCotroller {

	@GetMapping("/")
	public String start() {
		return "hello";
	}
}
