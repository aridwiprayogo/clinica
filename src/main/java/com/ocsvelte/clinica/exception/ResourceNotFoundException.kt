package com.ocsvelte.clinica.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
data class ResourceNotFoundException(override val message: String) : RuntimeException() {

    companion object {
        private const val serialVersionUID = 1L
    }

}