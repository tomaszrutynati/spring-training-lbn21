package pl.sda.springtraining.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String> handleError(RuntimeException ex) {
        return ResponseEntity
                .status(422)
                .body(ex.getMessage());
    }

}
