package com.max21lkm.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.max21lkm.item.domain.ItemDTO;
import com.max21lkm.item.service.ItemService;

@Controller
public class ItemViewController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="getall", 
			method=RequestMethod.GET)
	public String getAll(Model model){
		//�ʿ��� ���� �޼��� ȣ��
		List<ItemDTO> list = itemService.getAll();
		System.out.println(list);
		
		//�信 �����͸� ����
		model.addAttribute("list",list);
		
		//���̸� - ViewResolver �� �������� ���� �䰡 ����
		return "item/list";
	}
	
	//�Ķ���� ���·� �Ѿ���� �󼼺��� ��û ó��
	@RequestMapping(value="getitem/{itemid}",
			method=RequestMethod.GET)
	public String getItem(
			@PathVariable("itemid") Integer itemid,
			Model model) {
		ItemDTO dto = itemService.getItem(itemid);
		model.addAttribute("item", dto);
		return "item/getitem";
	}
	
}
