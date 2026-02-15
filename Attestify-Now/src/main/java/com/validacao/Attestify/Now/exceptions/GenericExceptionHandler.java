package com.validacao.Attestify.Now.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<ErrorBody> handleValidacaoException(ValidacaoException ex) {

        ErrorBody errorBody = ErrorBody.builder()
                .mensagem(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorBody> handleGenericException(Exception ex) {

        ErrorBody errorBody = ErrorBody.builder()
                .mensagem("Ocorreu um erro inesperado.")
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
    }
}
