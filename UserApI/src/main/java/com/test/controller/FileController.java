package com.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.entity.FileDB;
import com.test.file.response.ResponseFile;
import com.test.file.response.ResponseMessage;
import com.test.service.FileStorageService;



@RestController
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {

		String message = "";

		int statusCode = 0;

		try {
			fileStorageService.store(file);
			statusCode = 200;
			message = "file upload successfully  " + file.getOriginalFilename();

			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, statusCode));

		} catch (Exception e) {
			message = "could not upload file  " + file.getOriginalFilename();
			statusCode = 404;
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, statusCode));

		}
	}

	// getAll Files
	@GetMapping("/files_get/")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = fileStorageService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
					.path(dbFile.getId()).toUriString();

			return new ResponseFile(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	
	//get files
	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {

		FileDB db = fileStorageService.getFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + db.getName() + "\"")
				.body(db.getData());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	///
	
//	@PostMapping("/uploadFile")
//    public ResponseFile uploadFiles(@RequestParam("file") MultipartFile file) throws Exception {
//         FileDB fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//            .path("/downloadFile/")
//            .path(fileName.getName())
//            .toUriString();
//
//        return new ResponseFile(fileName.getName(), fileDownloadUri,
//            file.getContentType(), file.getSize());
//    }
//	
//	
//	
//	
//	@GetMapping("/downloadFile/{fileName:.+}")
//    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String name, HttpServletRequest request) {
//        // Load file as Resource
//        FileDB databaseFile = fileStorageService.getFile(name);
//        
//        return ResponseEntity.ok()
//        		.contentType(org.springframework.http.MediaType.parseMediaType(databaseFile.getType()))
//        		.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+databaseFile.getName()+"\"")
//        		.body(new ByteArrayResource(databaseFile.getData()));
//
//        
//    }
	
	
	

}
