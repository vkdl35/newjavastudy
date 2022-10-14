package com.max21lkm.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.max21lkm.item.domain.ItemDTO;

//Ŭ������ @Component �� �����ϸ� servlet-context.xml
//������ component-scan�� ������ ��Ű���� ���� ���
//bean�� �ڵ����� �����մϴ�.
//@Repository, @Service, @Controller, @RestController
//�� �����ϸ� ���ұ��� �ο��մϴ�.

//@Repository
public class ItemRepository {

	//@Autowired
	private SqlSession sqlSession;
	
	//���̺��� ��ü �����͸� �������� �޼���
	public List<ItemDTO> getAll() {
		return sqlSession.selectList(
			"itemmapper.getall");
	}
	
	//�ϳ��� �����͸� �������� �޼���
	public ItemDTO getItem(Integer itemid) {
		return sqlSession.selectOne(
				"itemmapper.getitem", itemid);
	}
	
}
