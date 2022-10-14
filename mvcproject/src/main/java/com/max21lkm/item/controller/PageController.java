package com.max21lkm.item.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.max21lkm.item.domain.MemberDTO;
import com.max21lkm.item.domain.ReportDTO;

import lombok.extern.log4j.Log4j;


//Controller를 만들기 위한 어노테이션
@Controller
//로그 출력을 위한 인스턴스를 생성하기 위한 어노테이션
@Log4j
public class PageController {
	//처리할 URL과 전송 방식
	@RequestMapping(value="blog/{num}",
			method=RequestMethod.GET)
	//Model은 뷰에게 데이터를 넘기기 위한 객체
	public String blog(
		@PathVariable String num, Model model) {
			
		//View에 데이터 전달
		//num이라는 이름으로 num이라는 데이터를 전달
		model.addAttribute("num", num);
		
		//출력할 뷰 이름 설정
		return "blog";
	}
	
	@RequestMapping(value="parameter",
			method=RequestMethod.GET)
	public String parameter(Model model) {
		return "parameter";
	}
	
	//파라미터를 HttpServletRequest를 이용해서 읽기
	@RequestMapping(value="getlink",
			method=RequestMethod.GET)
	public void getlink(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		System.out.println(name);
		System.out.println(job);
	}
	
	//파라미터를 @RequestParam을 이용해서 읽기
	@RequestMapping(value="getform",
			method=RequestMethod.GET)
	public void getlink(
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			Model model) {

		System.out.println(name);
		System.out.println(password);
	}
	
	//파라미터를 Command 객체를 이용해서 읽기
		@RequestMapping(value="postform",
				method=RequestMethod.POST)
		public void postform(
				MemberDTO dto,
				Model model) {

			System.out.println(dto);
		}
		
		@RequestMapping(value="fileupload",
				method=RequestMethod.POST)
		public void fileupload(ReportDTO dto,
				HttpServletRequest request) {
			if(dto.getPictureurl().isEmpty()) {
				System.out.println("업로드 파일이 없습니다.");
			} else {
				//프로젝트 내의 upload 디렉토리의 절대경로
				String filepath = request.getServletContext()
						.getRealPath("/upload");
				System.out.println(filepath);
				
				filepath = filepath  + "/" +
				UUID.randomUUID() +
				dto.getPictureurl().getOriginalFilename();
				
				File file = new File(filepath);
				try {					
					dto.getPictureurl().transferTo(file);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	
}
