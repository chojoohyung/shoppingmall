package com.yuhan.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhan.entity.Question;
import com.yuhan.repository.QuestionRepository;

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
