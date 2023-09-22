package com.yuhan.model;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
	
@Entity
@Data
public class Qa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
    private String title;
    private String content;
    private String content1;
    

}
