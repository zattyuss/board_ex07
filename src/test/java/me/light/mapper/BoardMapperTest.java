package me.light.mapper;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.model.BoardVO;
import me.light.model.Criteria;

public class BoardMapperTest extends AppTest{

	@Autowired
	BoardMapper mapper; 
	
	@Test
	public void getListTest() {
		Criteria criteria = new Criteria();
		criteria.setPage(2);
		mapper.getList(criteria);
	}
	
	@Test
	@Ignore
	public void getTest() {
		mapper.get(1L);
	}
	
	@Test
	@Ignore
	public void insertTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("�젣紐⑺뀒�뒪�듃");
		vo.setContent("�궡�슜�뀒�뒪�듃");
		vo.setWriter("湲��벖�씠");
		mapper.insert(vo);
	}

	@Test
	@Ignore
	public void updateTest() {
		BoardVO vo = new BoardVO();
		vo.setBno(5L);
		vo.setTitle("�젣紐⑺뀒�뒪�듃 --�닔�젙");
		vo.setContent("�궡�슜�뀒�뒪�듃 --�닔�젙");
		mapper.update(vo);
	}
	
	@Test
	@Ignore
	public void deleteTest() {
		mapper.delete(5L);
	}
	

	
	
}
