package com.grp5.bootcamp4.exceptions;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.*;

@RestControllerAdvice
public class CustomExceptionHandler{
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
            
        });
        
        return ResponseEntity.badRequest().body(errors);
    }
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(value = MethodArgumentNotValidException.class)
//	public @ResponseBody Map<String,Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
//		Map<String, Object> responseBody = new HashMap<>();
//		errors.put("timestamp", new Date());
//		errors.put("status",  status.value());
//		
//		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
//		responseBody.put("errors", errors);
//		System.out.println(responseBody);
//		return responseBody;
//	}
	
	@ExceptionHandler(value = RecordAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleRecordAlreadyExistsException(RecordAlreadyExistsException ex) {
		System.out.println(ex.getMessage());
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	}
	
	@ExceptionHandler(value = EmployeeDoesNotExistException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleEmployeeDoesNotExistException(EmployeeDoesNotExistException ex) {
		System.out.println(ex.getMessage());
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	}
	
	@ExceptionHandler(value = ItemIsNotAvailableException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleItemIsNotAvailableException(ItemIsNotAvailableException ex) {
		System.out.println(ex.getMessage());
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	}
	
	@ExceptionHandler(value = CustomErrorMessage.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleCustomErrorMessage(CustomErrorMessage ex) {
		System.out.println(ex.getMessage());
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	}
}
			