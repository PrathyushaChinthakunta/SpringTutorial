package com.week2.applic.exceptcontroller;

 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity; 
 import org.springframework.web.bind.annotation.ControllerAdvice; 
 import org.springframework.web.bind.annotation.ExceptionHandler; 

	@ControllerAdvice
	public class ExceptionController {

		@ExceptionHandler(value = ValueNotFoundException.class)
		public ResponseEntity<Object> exception(ValueNotFoundException exception) {
			return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
		}

		@ExceptionHandler(value = EnterValue.class)
		public ResponseEntity<Object> empty(EnterValue exception) {
			return new ResponseEntity<>("The name should not be empty", HttpStatus.NOT_FOUND);
		}
	}
 
