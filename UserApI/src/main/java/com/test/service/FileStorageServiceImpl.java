package com.test.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import io.micrometer.common.util.StringUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.test.entity.FileDB;
import com.test.repository.FileDBRepository;

@Service
public class FileStorageServiceImpl implements FileStorageService{

	@Autowired
	private FileDBRepository fileDBRepository;
	@Override
	public FileDB store(MultipartFile file) throws IOException {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		FileDB fileDB = new FileDB(fileName,file.getContentType(),file.getBytes());
		
		return fileDBRepository.save(fileDB);
	}
	
	@Override
	public Stream<FileDB> getAllFiles() {
		
		return fileDBRepository.findAll().stream();
		
	}

	
	public FileDB getFile(String id) {
	    return fileDBRepository.findById(id).get();
	  }
	

	
	
	
	
	
	
	
	
	
	
	
	
	
//	public FileDB storeFile(MultipartFile file) throws IOException {
//        // Normalize file name
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//       
//
//            FileDB  filedb= new FileDB(fileName, file.getContentType(), file.getBytes());
//
//            return fileDBRepository.save(filedb);
//       
//    }
//	
//	public FileDB  getFiles(String id) throws FileNotFoundException   {
//		
//		FileDB f=	fileDBRepository.findById(id).orElseThrow(()-> new FileNotFoundException("file not found with "+id));
//	
//	return f;
//	
//	}
//	
//	
//	
	
}
