package com.sf.syu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sf.syu.response.CustomResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> handleResponse(CustomException customException){
		CustomResponse response=new CustomResponse();
		response.setIsError(true);
		response.setMsg(customException.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}
