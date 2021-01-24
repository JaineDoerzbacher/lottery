package com.random.lottery.gateway.controller

import com.random.lottery.dtos.ErrorMessage
import com.random.lottery.exceptions.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ErrorController : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [IllegalArgumentException::class])
    fun argurmentoIlegal(exception: Exception): ResponseEntity<ErrorMessage> {

        if (exception.message != null) {
            return ResponseEntity(ErrorMessage("Argumento inválido", exception.message!!), HttpStatus.BAD_REQUEST)
        } else {
            return ResponseEntity(
                ErrorMessage("Argumento inválido", "O parametro recebido é inválido"),
                HttpStatus.BAD_REQUEST
            )
        }
    }

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun entidadeNaoEncontrada(exception: Exception): ResponseEntity<ErrorMessage> {

        if (exception.message != null) {
            return ResponseEntity(ErrorMessage("Entidade não encontrada", exception.message!!), HttpStatus.NOT_FOUND)
        } else {
            return ResponseEntity(
                ErrorMessage("Entidade não encontrada", "A entidade não foi encontrada"),
                HttpStatus.NOT_FOUND
            )
        }
    }

    @ExceptionHandler(value = [Exception::class])
    fun erroDesconhecido(exception: Exception): ResponseEntity<ErrorMessage> {

        return ResponseEntity(
            ErrorMessage("Erro desconhecido", "Um erro desconhecido foi encontrado no programa"),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}