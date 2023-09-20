package com.yuhan.repository;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.yuhan.constant.ProductSellStatus;
import com.yuhan.entity.ProductEntity;

@SpringBootTest
@TestPropertySource(locations = "classpath:/application-test.properties")
class ProductRepositoryTest {
	
	@Autowired
	ProductRepository productRepository;
	

	@Test
	@DisplayName("상품 저장 테스트")
	public void createProductTest() {
		ProductEntity product = new ProductEntity();
		product.setId(3L);
		product.setName("asd");
		product.setProductSellStatus(ProductSellStatus.SELL);
		
		
		ProductEntity savedProduct = productRepository.save(product);
		System.out.println(savedProduct.toString());
		
	}

	public void createProductList() {
		for (int i = 0; i < 10; i++) {
			ProductEntity product = new ProductEntity();
			product.setName("테스트상품 "+i+" 번");
			product.setProductSellStatus(ProductSellStatus.SELL);
			ProductEntity saveProduct = productRepository.save(product);
		}
	}
	
	
	@Test
	@DisplayName("상품명 조회 테스트")
	public void findByProductNameTest() {
		this.createProductList();
		List<ProductEntity> productList = productRepository.findByName("테스트상품 2 번");
		for (ProductEntity productEntity : productList) {
			System.out.println(productEntity.toString());
		}
	}
	
	
	
	
}
