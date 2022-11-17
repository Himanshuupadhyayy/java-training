package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper helper;
	
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		System.out.println(file.getContentType());					//image/png
		System.out.println(file.getName());							//file
		System.out.println(file.getOriginalFilename());				//Screenshot (1).png
		System.out.println(file.getSize());							//136291 in the form of byte
		try {
			
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
		}
		if(!file.getContentType().equals("image/png")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only png file is allowed");		
		}
		
		//file upload code
		boolean f=helper.uploadFile(file);
		if(f) {
		return	ResponseEntity.ok("file is successfull uplaod");
		}else {
			return ResponseEntity.ok("faild");
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong !!");
				}
}