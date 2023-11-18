package com.yuhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.yuhan.entity.ProductImg;
import com.yuhan.entity.Used;
import com.yuhan.entity.UsedImg;
import com.yuhan.repository.UsedImgRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsedImgService {
	
	@Value("${usedImgLocation}")
	private String usedImgLocation;
	
	private final UsedImgRepository usedImgRepository;
	
	private final FileService fileService;
	
	public void saveUsedImg(UsedImg usedImg, MultipartFile usedImgFile) throws Exception{
		String oriImgNam = usedImgFile.getOriginalFilename();
		String imgName = "";
		String imgUrl = "";
		
		//파일 업로드
		if(!StringUtils.isEmpty(oriImgNam)) {
			imgName = fileService.uploadFile(usedImgLocation, oriImgNam, usedImgFile.getBytes());
			imgUrl = "/img/usedImg/" + imgName; 
		}
		
		//상품 저장
		usedImg.updateUsedImg(oriImgNam, imgName, imgUrl);
		usedImgRepository.save(usedImg);
	}
	
	public void updateUsedImg(Long usedImgid, MultipartFile usedImgFile) throws Exception{
		if(!usedImgFile.isEmpty()) {
			UsedImg savedUsedImg = usedImgRepository.findById(usedImgid).orElseThrow(EntityNotFoundException::new);
			//기본 이미지 파일 삭제
			if(!StringUtils.isEmpty(savedUsedImg.getImgName())) {
				fileService.deleteFile(usedImgLocation+"/"+savedUsedImg.getImgName());
			}
			String oriImgName = usedImgFile.getOriginalFilename();
			String imgName = fileService.uploadFile(usedImgLocation, oriImgName, usedImgFile.getBytes());
			String imgUrl = "/img/usedImg/" + imgName;
			savedUsedImg.updateUsedImg(oriImgName, imgName, imgUrl);
			
		}
	}
	
	public List<UsedImg> findByUsed(Used used){
		List<UsedImg> usedImgList = usedImgRepository.findByUsed(used);
		return usedImgList;
	}
	
	public void delete(UsedImg usedImg) {
		usedImgRepository.delete(usedImg);
	}
	
}
