package com.vianny.dto.response

import io.micronaut.http.HttpStatus
import io.micronaut.serde.annotation.Serdeable

@Serdeable.Serializable
class MainResponseDTO (
    val httpStatus: HttpStatus,
    val message: Any
)