package com.lti.plutusloan.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	public StringBuilder uploadFile(MultipartFile[] files,String uploadDirectory);
}
