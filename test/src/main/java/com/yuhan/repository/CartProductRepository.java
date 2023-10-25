package com.yuhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yuhan.dto.CartDetailDto;
import com.yuhan.entity.Cart;
import com.yuhan.entity.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
	
	CartProduct findByCartIdAndProductId(Long id, Long productId);
	
	
	@Query("SELECT new com.yuhan.dto.CartDetailDto(cp.id, p.name, p.price, p.size, p.color, cp.count, pi.imgUrl) FROM CartProduct cp, ProductImg pi JOIN cp.product p WHERE cp.cart.id = :cartId AND pi.product.id = cp.product.id GROUP BY cp.id ORDER BY cp.id desc")
	List<CartDetailDto> findCartDetailDtoList(@Param("cartId") Long cartId);
	
}