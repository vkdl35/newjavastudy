package com.max21lkm.item;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.max21lkm.item.dao.ItemRepository;
import com.max21lkm.item.domain.ItemDTO;

//�׽�Ʈ�� ���� Ŭ������ �ε�
//JUnit - Java �� ���� �׽�Ʈ�� ���̺귯��, Eclipse ����
@RunWith(SpringJUnit4ClassRunner.class)

//���� ������ �о�ɴϴ�.
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class ItemTest {
	//DataSource ����
	@Autowired
	private DataSource dataSource;
	
	//�׽�Ʈ �޼��带 ����� ���� ������̼�
	//@Test
	public void testConnection() {
		try(Connection con = 
				dataSource.getConnection()){
			System.out.println(con);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
	
	@Autowired
	private SqlSession sqlSession;
	
	//@Test
	public void testMyBatis() {
		System.out.println(sqlSession);
	}
	
	@Autowired
	private ItemRepository itemRepository;
	
	public void testGetAll() {
		System.out.println(itemRepository.getAll());
	}
	
	
	
}




