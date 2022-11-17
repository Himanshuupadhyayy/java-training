package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.helper.FileResponse;
import com.api.helper.uploadServices;

@RestController
public class UplaodController {

	@Autowired
	private uploadServices services;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(
			@RequestParam("image") MultipartFile image
			){
		
		String fileName=null;
		try {
			if(image.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			if(!image.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
			}
			fileName=this.services.uploadImage(path, image);			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(new FileResponse(fileName, "image is successfully uploaded"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new FileResponse(fileName, "image is successfully uploaded"), HttpStatus.OK);
	}
	
}