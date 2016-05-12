package br.com.hsj.ep119.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.hsj.ep119.api.domain.ErrorInfo;
import br.com.hsj.ep119.api.exception.ApplicationException;
import br.com.hsj.ep119.api.exception.UserNotFoundException;

public abstract class AbstractRestController {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> exceptionForUserNotFound(HttpServletRequest req, Exception e) {
		String detail = e != null ? e.getMessage() : null;
		ErrorInfo error = new ErrorInfo(1, "Usuário não encontrado!", detail);
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorInfo> applicationException(HttpServletRequest req, Exception e) {
		String detail = e != null ? e.getMessage() : null;
		ErrorInfo error = new ErrorInfo(1, "Ocorreu um erro na aplicação!", detail);
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
}
