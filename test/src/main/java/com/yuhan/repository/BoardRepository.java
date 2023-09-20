package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yuhan.constant.ProductSellStatus;
import com.yuhan.entity.BoardEntity;
import com.yuhan.entity.ProductEntity;


public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

	/*
	 * find + (Entity 이름) + By + (컬럼이름) 시 자동 Query 생성
	 */
	List<BoardEntity> findByTitle(String title);
	
	
	/*
	//@Query 사용법
	@Query("select * "
		+ "from board "
		+ "where title like %:title% order by idx desc")
	List<BoardEntity> findByTitle(String title);
	*/
	
}
