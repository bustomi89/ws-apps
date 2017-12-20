package com.dybar;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.dybar.utility.upload.storage.StorageService;

@SpringBootApplication
public class MyApplication{  
	
//public class MyApplication extends SpringBootServletInitializer{  
	

	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
    }       
	
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(MyApplication.class);
//        
//        
//    }
	
	public void run(String... arg) throws Exception {
		//storageService.deleteAll();
		storageService.init();
	}
	
	 @PostConstruct
	  public void init(){
	     // init code goes here
		 storageService.init();
	  }
	 
}            