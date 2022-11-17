package com.api.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR="C:\\Users\\Development\\Desktop\\Spring_Boot_Projec\\RestAPIProjectWithDifferentValidation\\src\\main\\resources\\static\\image";
			
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f=false;
		try {
		//firstly read the data from file	
/*		InputStream is	=multipartFile.getInputStream();
		byte data[]=new byte[is.available()];
		is.read(data);
		System.out.println("line 3");

		//write the data
		FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
		System.out.println("line 4");
		fos.write(data);
		System.out.println("line 5");
		fos.flush();
		System.out.println("line 6");
		fos.close();
		System.out.println("line 7");
		f=true;
		
*/
			System.out.println("hello");
		Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
		f=true;
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

}