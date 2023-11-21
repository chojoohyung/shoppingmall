package com.yuhan.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhan.entity.Faq;
import com.yuhan.repository.FaqRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqService {
	private final FaqRepository faqRepository;
	public void save(Faq faq) {
		faqRepository.save(faq);
		
	}
	public List<Faq> findAll(){
		return faqRepository.findAll();
	}
}
