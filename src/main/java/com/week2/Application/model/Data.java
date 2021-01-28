package com.week2.Application.model;

import javax.validation.constraints.NotEmpty; 

public class Data {
	  private String id;   
	  @NotEmpty(message = "Name must not be empty")    
	  private String name; 
	  public String getId() {   
		  return id;   
	  }  
	  public void setId(String id) {   
		  this.id = id; 
	  }
	  public String getName() {       
		  return name;   
	  }    
	  public void setName(String name) {     
		  this.name = name;    
	  } 
	 

}
