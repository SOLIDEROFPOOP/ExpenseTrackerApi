package com.muratkapparov.expensetracker.exception;

import com.muratkapparov.expensetracker.entity.ExpenseErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExpenseErrorException> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest webRequest){
        ExpenseErrorException error = new ExpenseErrorException();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(new Date());
        return new ResponseEntity<ExpenseErrorException>(error, HttpStatus.NOT_FOUND);
    }
}
