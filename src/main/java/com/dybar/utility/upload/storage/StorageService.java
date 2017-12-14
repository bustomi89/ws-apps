package com.dybar.utility.upload.storage;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("../upload-dir");

	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	
	public void renamestore(MultipartFile file, String newName) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(newName));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
	
	public void deleteFile(String filename) {
		File file = new File(rootLocation.toFile() +"/"+filename);
		file.delete();
	//	System.out.println("delete : "+rootLocation.toFile() +"/"+filename);
	}
	
	public void renameFile(String oldFile, String newFile) {
		File oldfile =new File(rootLocation.toFile() +"/"+oldFile);
		File newfile =new File(rootLocation.toFile() +"/"+newFile);
		System.out.println("old file : "+rootLocation.toFile() +"/"+oldFile);
		System.out.println("new file : "+rootLocation.toFile() +"/"+newFile);
		
		if(oldfile.renameTo(newfile)){
			System.out.println("Rename succesful");
		}else{
			System.out.println("Rename failed");
		}
	}
	
	

	public void init() {
		if (Files.notExists(rootLocation)) {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
		}
	}
}
