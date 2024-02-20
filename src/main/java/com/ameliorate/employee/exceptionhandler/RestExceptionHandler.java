package com.ameliorate.employee.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ameliorate.employee.exception.CustomException;
import com.ameliorate.employee.pojo.ErrorResponseEntity;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  private static final int PRECONDITION_FAILED = 412;

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponseEntity>resourceNotFoundException(
		  CustomException ex, WebRequest request) {
    ErrorResponseEntity message =
        new ErrorResponseEntity(HttpStatus.PRECONDITION_FAILED.value(), ex.getMessage());

    return new ResponseEntity<ErrorResponseEntity>(message, HttpStatus.PRECONDITION_FAILED);
  }
  
//  @ExceptionHandler(CustomException.class)
//  public ResponseEntity<Object> handleUserUpdateException(CustomException ex) {
//      Map<String, String> responseBody = new HashMap<>();
//      responseBody.put("error", ex.getMessage());
//      return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
//  }
  
}
