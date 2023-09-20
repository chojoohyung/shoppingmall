package com.yuhan.repository;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.yuhan.constant.ProductSellStatus;
import com.yuhan.entity.BoardEntity;
import com.yuhan.entity.ProductEntity;

@SpringBootTest
@TestPropertySource(locations = "classpath:/application-test.properties")
class BoardRepositoryTest {
	
	@Autowired
	BoardRepository boardRepository;
	

	@Test
	@DisplayName("q/a게시판 저장 테스트")
	public void createBoardTest() {
		BoardEntity board = new BoardEntity();
		board.setTitle("Board 테이블 Test / title");
		board.setContent("Board 테이블 Test / content");
		
		BoardEntity savedBoard = boardRepository.save(board);
		System.out.println(savedBoard.toString());
		
	}

	
	public void createBoardList() {
		for (int i = 0; i < 10; i++) {
			BoardEntity board = new BoardEntity();
			board.setTitle("테스트제목 "+i+" 번");
			board.setContent("content test");
			BoardEntity saveboard = boardRepository.save(board);
		}
	}
	
	
	@Test
	@DisplayName("상품명 조회 테스트")
	public void findByBoardNameTest() {
		this.createBoardList();
		List<BoardEntity> boardList = boardRepository.findByTitle("테스트상품 2 번");
		for (BoardEntity boardEntity : boardList) {
			System.out.println(boardEntity.toString());
		}
	}
	
	
}
