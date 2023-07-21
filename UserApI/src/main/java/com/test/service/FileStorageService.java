package com.test.service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.entity.FileDB;

@Service
public interface FileStorageService {
	
	
	public FileDB  store(MultipartFile file) throws Exception;
	
	
	public Stream<FileDB> getAllFiles();
	
	public FileDB getFile(String id);
	
	
//	public FileDB storeFile(MultipartFile file) throws Exception;

}
