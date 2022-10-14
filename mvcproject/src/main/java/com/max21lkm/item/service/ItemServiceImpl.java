package com.max21lkm.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max21lkm.item.dao.ItemMapper;
import com.max21lkm.item.dao.ItemRepository;
import com.max21lkm.item.domain.ItemDTO;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	//private ItemRepository itemRepository;
	private ItemMapper itemRepository;

	@Override
	public List<ItemDTO> getAll() {
		return itemRepository.getAll();
	}

	@Override
	public ItemDTO getItem(Integer itemid) {
		return itemRepository.getItem(itemid);
	}
	
	
}
