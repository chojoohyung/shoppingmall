package com.yuhan.repository;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.yuhan.constant.Size;
import com.yuhan.entity.Product;

@SpringBootTest
@TestPropertySource(locations = "classpath:/application-test.properties")
class ProductRepositoryTest {
	
	@Autowired
	ProductRepository productRepository;
	

	@Test
	@DisplayName("상품 저장 테스트")
	public void createProductTest() {
		
		Product product = new Product();
		product.setName("검정티");
		product.setPrice(10000);
		product.setColor("검정");
		product.setSize(Size.S);
		product.setStock(100);
		product.setCategory("상의");
		
		
		
		Product savedProduct = productRepository.save(product);
		System.out.println(savedProduct.toString());
		
	}

	public void createProductList() {
		for (int i = 0; i < 10; i++) {
			Product product = new Product();
			product.setName("검정티");
			product.setPrice(10000);
			product.setColor("검정");
			product.setSize(Size.S);
			product.setStock(100);
			product.setCategory("상의");
			
			Product saveProduct = productRepository.save(product);
		}
	}
	
	
	@Test
	@DisplayName("상품명 조회 테스트")
	public void findByProductNameTest() {
		this.createProductList();
		List<Product> productList = productRepository.findProductByName("티");
		for (Product product : productList) {
			System.out.println(product.toString());
		}
	}
	
	
	
	
}
