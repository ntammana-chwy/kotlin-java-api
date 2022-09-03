package com.learning.api.exception

import com.learning.api.response.KotlinErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class KotlinGlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(KotlinTestException::class)
    fun handleTestException(ex: KotlinTestException): ResponseEntity<KotlinErrorResponse> =
        KotlinErrorResponse(errorCode = 400, errorMessage = ex.message)
            .let { ResponseEntity.badRequest().body(it) }
}
