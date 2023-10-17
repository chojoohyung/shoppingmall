package com.yuhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuhan.entity.Used;
import com.yuhan.entity.UsedImg;

public interface UsedImgRepository extends JpaRepository<UsedImg,  Long> {
	

}
