package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.Used;
import com.yuhan.entity.UsedImg;

public interface UsedImgRepository extends JpaRepository<UsedImg,  Long> {
	
	List<UsedImg> findByUsed(Used used);
}
