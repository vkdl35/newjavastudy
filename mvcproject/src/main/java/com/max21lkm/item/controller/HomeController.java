package com.max21lkm.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//hello��� ��û�� ���� hello��� view �̸��� ����
	//view�� servlet-context.xml ������
	//ViewResolver�� ������ �����ؼ� ��ġ�� �����մϴ�.
	@RequestMapping(value = "hello", 
			method = RequestMethod.GET)
	public String hello( Model model) {
		
		return "hello";
	}
	
}
