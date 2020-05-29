package com.lti.plutusloan.serviceimp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lti.plutusloan.service.FileUploadService;

@Service
public class FileUploadServiceImp implements FileUploadService {

	public StringBuilder uploadFile(MultipartFile[] files, String uploadDirectory) {
		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileNames;
	}
}
