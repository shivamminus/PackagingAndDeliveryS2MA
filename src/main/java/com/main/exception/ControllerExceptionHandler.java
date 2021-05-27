package com.main.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.main.dto.ErrorMessage;


@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = { InvalidTokenException.class})
	public ResponseEntity<ErrorMessage> loginExceptionHandel(Exception ex, WebRequest request) {
		final Date date = new Date();
		ErrorMessage message = new ErrorMessage( date, ex.getMessage());

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value = { ComponentTyepNotFoundException.class})
	public ResponseEntity<ErrorMessage> invalidLoginCredentialHandel(Exception ex, WebRequest request) {
		final Date date = new Date();
		ErrorMessage message = new ErrorMessage( date, ex.getMessage());

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorMessage> handleError404(Exception ex, WebRequest request) {
		final Date date = new Date();
		ErrorMessage message = new ErrorMessage( date, ex.getMessage());

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
	
	
}