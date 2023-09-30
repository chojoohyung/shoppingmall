package com.yuhan.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class FileService {
	public String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws Exception{
		UUID uuid = UUID.randomUUID();
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String savedFileName = uuid.toString()+extension;
		String fileUploadFullUrl = uploadPath + "/" +savedFileName;
		FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
		fos.write(fileData);
		fos.close();
		return savedFileName;
		
	}
	
	public void deleteFile(String filePath) throws Exception{
		File deleteFile = new File(filePath);
		
		if(deleteFile.exists()) {
			deleteFile.delete();
			System.out.println("파일이 삭제되었습니다");
		}
		else {
			System.out.println("파일이 존재하지 않습니다");
		}
	}
	
}
