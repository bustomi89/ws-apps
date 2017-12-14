package com.dybar.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.dybar.utility.upload.storage.StorageService;



//@RestController
@CrossOrigin(origins = {"*"})
@Controller
public class UploadFilesController {

	@Autowired
	StorageService storageService;

	List<String> files = new ArrayList<String>();

//	@PreAuthorize("hasAuthority('TRANSAKSI_ADD_EDIT')")
	@PostMapping("/uploadfile/post")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file ) {
		String message = "";
		try {
			storageService.store(file);
			files.add(file.getOriginalFilename());

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
//	@PreAuthorize("hasAuthority('TRANSAKSI_ADD_EDIT')")
	@PostMapping("/uploadfile/renamepost/{newName:.+}")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable String newName ) {
		String message = "";
		try {
			storageService.renamestore(file,newName);
			files.add(file.getOriginalFilename());

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

//	@PreAuthorize("hasAuthority('TRANSAKSI_VIEW')")
	@GetMapping("/uploadfile/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(UploadFilesController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}

//	@PreAuthorize("permitAll()")
//	@PreAuthorize("hasAuthority('TRANSAKSI_VIEW')")
	@GetMapping("/uploadfile/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	

//	@PreAuthorize("hasAuthority('TRANSAKSI_ADD_EDIT')")
	@DeleteMapping(value="uploadfile/delete/{filename:.+}")
	public void deleteFile (@PathVariable String filename){
		
		storageService.deleteFile(filename);
	}
	
//	@PreAuthorize("hasAuthority('TRANSAKSI_VIEW')")
	@GetMapping(value="uploadfile/rename/{oldFile:.+}/{newFile:.+}")
	public void renameFile (@PathVariable String oldFile, @PathVariable String newFile){
		
		storageService.renameFile(oldFile,newFile);
	}
	
}
