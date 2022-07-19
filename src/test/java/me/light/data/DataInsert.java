package me.light.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.mapper.BoardMapper;
import me.light.model.BoardVO;

public class DataInsert extends AppTest{

	@Autowired
	BoardMapper mapper;
	
	
	@Test
	public void dataInsert() {
		for (int i = 1; i <= 412; i++) {
			
		BoardVO vo = new BoardVO();
		vo.setTitle("제목"+i);
		vo.setContent("내용"+i);
		vo.setWriter("성자"+i);
		mapper.insert(vo);
		}
	}
}
