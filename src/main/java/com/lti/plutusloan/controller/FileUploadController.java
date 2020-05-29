package com.lti.plutusloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lti.plutusloan.service.FileUploadService;

@RestController
@CrossOrigin
public class FileUploadController {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping(path = "/upload", consumes = "multipart/form-data")
	public String upload(Model model, @RequestParam("image") MultipartFile[] files) {

		StringBuilder fileNames = fileUploadService.uploadFile(files, uploadDirectory);

		return "{\"status\":\"Successfully uploaded files\"}" + fileNames.toString();

	}

}
