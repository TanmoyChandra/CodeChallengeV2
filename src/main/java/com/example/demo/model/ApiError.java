package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	   private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String message;
	   private FieldError debugMessage;

	   public ApiError(HttpStatus status, String message, Errors errors) {
		   this.timestamp = LocalDateTime.now();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = errors.getFieldError();
	   }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FieldError getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(FieldError debugMessage) {
		this.debugMessage = debugMessage;
	}
	}
