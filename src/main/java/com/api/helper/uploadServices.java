package com.api.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class uploadServices {

	public String uploadImage(String path, MultipartFile file) throws IOException {
		//file name
		String name=file.getOriginalFilename();
		
		//random name generate of file 
		String randomID=UUID.randomUUID().toString();
		String fileName1=randomID.concat(name.substring(name.lastIndexOf(".")));
		//full file path
		String filePath=path+ File.separator+name;
		
		//create folder if not create
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		//file copy and upload file
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return name;
	}	
}