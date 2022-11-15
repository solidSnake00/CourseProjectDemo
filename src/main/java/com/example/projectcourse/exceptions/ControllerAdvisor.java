package com.example.projectcourse.exceptions;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerIdException(@NotNull CustomerNotFoundException ex, WebRequest webRequest){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp: ", LocalDateTime.now());
        body.put("message: ", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(AllCustomersNotFoundException.class)
    public ResponseEntity<Object> handleAllCustomersException(@NotNull AllCustomersNotFoundException ex, WebRequest webRequest){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp: ", LocalDateTime.now());
        body.put("message: ", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    /////////////////////////////////
    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<Object> handleAdminIdException(@NotNull AdminNotFoundException ex, WebRequest webRequest){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp: ", LocalDateTime.now());
        body.put("message: ", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(AllAdminNotFoundException.class)
    public ResponseEntity<Object> handleAllAdminException(@NotNull AllAdminNotFoundException ex, WebRequest webRequest){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp: ", LocalDateTime.now());
        body.put("message: ", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    //////////////////////////////////

    @ExceptionHandler(PlanNotFoundException.class)
    public ResponseEntity<Object> handlePlanIdException(@NotNull PlanNotFoundException ex, WebRequest webRequest){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp: ", LocalDateTime.now());
        body.put("message: ", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(AllPlanNotFoundException.class)
    public ResponseEntity<Object> handleAllPlanException(@NotNull AllPlanNotFoundException ex, WebRequest webRequest){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp: ", LocalDateTime.now());
        body.put("message: ", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }
}
