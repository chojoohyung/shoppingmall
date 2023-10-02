package com.yuhan.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.yuhan.entity.ProductImg;
import com.yuhan.repository.ProductImgRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductImgService {

	@Value("${productImgLocation}")
	private String productImgLocation;
	
	private final ProductImgRepository productImgRepository;
	
	private final FileService fileService;
	
	public void saveProductImg(ProductImg productImg, MultipartFile productImgFile) throws Exception{
		String oriImgNam = productImgFile.getOriginalFilename();
		String imgName = "";
		String imgUrl = "";
		
		//파일 업로드
		if(!StringUtils.isEmpty(oriImgNam)) {
			imgName = fileService.uploadFile(productImgLocation, oriImgNam, productImgFile.getBytes());
			imgUrl = "/img/productImg/" + imgName; 
		}
		
		//상품 저장
		productImg.updateProductImg(oriImgNam, imgName, imgUrl);
		productImgRepository.save(productImg);
	}
	
	public void updateProductImg(Long productImgid, MultipartFile productImgFile) throws Exception{
		if(!productImgFile.isEmpty()) {
			ProductImg savedProductImg = productImgRepository.findById(productImgid).orElseThrow(EntityNotFoundException::new);
			//기본 이미지 파일 삭제
			if(!StringUtils.isEmpty(savedProductImg.getImgName())) {
				fileService.deleteFile(productImgLocation+"/"+savedProductImg.getImgName());
			}
			String oriImgName = productImgFile.getOriginalFilename();
			String imgName = fileService.uploadFile(productImgLocation, oriImgName, productImgFile.getBytes());
			String imgUrl = "/img/product/" + imgName;
			savedProductImg.updateProductImg(oriImgName, imgName, imgUrl);
			
		}
	}
	
	
}
