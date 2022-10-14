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


//Controller�� ����� ���� ������̼�
@Controller
//�α� ����� ���� �ν��Ͻ��� �����ϱ� ���� ������̼�
@Log4j
public class PageController {
	//ó���� URL�� ���� ���
	@RequestMapping(value="blog/{num}",
			method=RequestMethod.GET)
	//Model�� �信�� �����͸� �ѱ�� ���� ��ü
	public String blog(
		@PathVariable String num, Model model) {
			
		//View�� ������ ����
		//num�̶�� �̸����� num�̶�� �����͸� ����
		model.addAttribute("num", num);
		
		//����� �� �̸� ����
		return "blog";
	}
	
	@RequestMapping(value="parameter",
			method=RequestMethod.GET)
	public String parameter(Model model) {
		return "parameter";
	}
	
	//�Ķ���͸� HttpServletRequest�� �̿��ؼ� �б�
	@RequestMapping(value="getlink",
			method=RequestMethod.GET)
	public void getlink(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		System.out.println(name);
		System.out.println(job);
	}
	
	//�Ķ���͸� @RequestParam�� �̿��ؼ� �б�
	@RequestMapping(value="getform",
			method=RequestMethod.GET)
	public void getlink(
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			Model model) {

		System.out.println(name);
		System.out.println(password);
	}
	
	//�Ķ���͸� Command ��ü�� �̿��ؼ� �б�
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
				System.out.println("���ε� ������ �����ϴ�.");
			} else {
				//������Ʈ ���� upload ���丮�� ������
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
