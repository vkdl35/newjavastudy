package com.max21lkm.item.service;

import java.util.List;

import com.max21lkm.item.domain.ItemDTO;

public interface ItemService {
	//���̺��� ��ü �����͸� �������� �޼���
	public List<ItemDTO> getAll();
	
	//�󼼺��� ó���� ���� �޼���
	public ItemDTO getItem(Integer itemid);
}
