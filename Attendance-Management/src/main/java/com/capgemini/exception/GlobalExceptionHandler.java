package com.capgemini.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler 
{
	
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ErrorDetails> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), "Validation Failed",ex.getBindingResult().toString());
		  return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		}
	
	    @ExceptionHandler(DuplicateRecordException.class)
	    public ResponseEntity<ErrorDetails> DuplicateRecordException(DuplicateRecordException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.CONFLICT);
	    }
	    
	    @ExceptionHandler(RecordNotFoundException.class)
	    public ResponseEntity<ErrorDetails> RecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(StudentNotFoundException.class)
	    public ResponseEntity<ErrorDetails> StudentNotFoundException(StudentNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(SubjectNotFoundException.class)
	    public ResponseEntity<ErrorDetails> SubjectNotFoundException(SubjectNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    @ExceptionHandler(Exception.class) 
		  public ResponseEntity<ErrorDetails> globleExcpetionHandler(Exception ex, WebRequest request) { ErrorDetails
		  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
		  return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); }

}
