package com.week2.Application.Controller;

import java.util.HashMap;
import java.util.Map; 
import javax.validation.Valid; 
 import org.springframework.http.HttpStatus; 
 import org.springframework.http.ResponseEntity; 
 import org.springframework.validation.BindingResult; 
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable; 
 import org.springframework.web.bind.annotation.PostMapping; 
 import org.springframework.web.bind.annotation.PutMapping; 
 import org.springframework.web.bind.annotation.RequestBody; 
 import org.springframework.web.bind.annotation.RestController;

import com.week2.Application.ExceptController.EnterValue;
import com.week2.Application.ExceptController.ValueNotFoundException;
import com.week2.Application.model.Data; 
 
 
 @RestController 
 public class Controller {    
	 private static Map<String, Data> data = new HashMap<>();   
	 static { 
		 Data a = new Data();       
		 a.setId("1");     
		 a.setName("Usha");   
		 data.put(a.getId(), a);
		 
		 Data b = new Data();      
		 b.setId("2");       
		 b.setName("Arun");      
		 data.put(b.getId(), b); 
		 
		 Data c = new Data();      
		 c.setId("3");       
		 c.setName("Bunny");      
		 data.put(c.getId(), c); 
	 }
	
	 @PutMapping("show/{id}")  
	 public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Data data1) {   
		 if(!data.containsKey(id))throw new ValueNotFoundException();  
		 data.remove(id);      
		 data.put(id, data1);
		 return new ResponseEntity<>("data is updated", HttpStatus.OK); 
	 }
	 
	 @PostMapping("/upload")  
	 public ResponseEntity<Object> addUser(@Valid @RequestBody Data data1, BindingResult result) { 
		 if (result.hasErrors()) throw new EnterValue();  
		 data.put(data1.getId(), data1);         
		 return ResponseEntity.ok("Uploaded");   
	 }
	 
	  @GetMapping("getdetails")    
	  public Map<String, Data> getdetails(){    
		  return data; 
	  }
 }
 