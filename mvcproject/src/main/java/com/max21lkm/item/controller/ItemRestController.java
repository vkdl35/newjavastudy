package com.max21lkm.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.max21lkm.item.domain.ItemDTO;
import com.max21lkm.item.service.ItemService;

@RestController
public class ItemRestController {
	@Autowired
	private ItemService itemService;
	
	//���̺��� ������ ��ü ���
	@RequestMapping(value="list.json",
			method=RequestMethod.GET)	
	public Map<String, Object> getAll() {
		Map<String, Object> map = new HashMap<>();
		List<ItemDTO> list = itemService.getAll();
		
		map.put("result", true);
		map.put("data", list);		
		return map;
	}
	
	//�󼼺���
	@RequestMapping(value="{itemid}/item.json",
			method=RequestMethod.GET)
	public Map<String, Object> getItem(
			@PathVariable("itemid") Integer itemid){
		Map <String, Object> map = new HashMap<>();
		ItemDTO item = itemService.getItem(itemid);
		
		map.put("result", true);
		map.put("data", item);	
		
		return map;
	}
}
