package com.example.testing.controller

import com.example.testing.usecase.PrecondicionInvalidaException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

data class ErrorResponse(val error: String)

@RestControllerAdvice
class ManejadorDeErrores {

    @ExceptionHandler(PrecondicionInvalidaException::class)
    fun manejarPrecondicion(e: PrecondicionInvalidaException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(e.message ?: "Error de precondición"))
}