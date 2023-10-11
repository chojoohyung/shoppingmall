package com.yuhan.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yuhan.dto.OrderFormDto;
import com.yuhan.entity.Order;
import com.yuhan.entity.OrderProduct;
import com.yuhan.entity.Product;
import com.yuhan.entity.Question;
import com.yuhan.entity.User;
import com.yuhan.repository.OrderRepository;
import com.yuhan.repository.ProductRepository;
import com.yuhan.repository.QuestionRepository;
import com.yuhan.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
	private final QuestionRepository questionRepository;
	public void save(Question question) {
		questionRepository.save(question);
		
	}
	public List<Question> findAll(){
		return questionRepository.findAll();
	}
}
