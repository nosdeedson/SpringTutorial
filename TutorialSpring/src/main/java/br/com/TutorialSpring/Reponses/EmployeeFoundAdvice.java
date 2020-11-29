package br.com.TutorialSpring.Reponses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.TutorialSpring.BusinessException.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus( HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler( EmployeeNotFoundException error) {
		return error.getMessage();
	}	

}
