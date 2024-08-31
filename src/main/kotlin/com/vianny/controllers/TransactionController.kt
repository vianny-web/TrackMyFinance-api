package com.vianny.controllers

import com.vianny.dto.response.MainResponseDTO
import com.vianny.dto.TransactionDTO
import com.vianny.services.TransactionService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import jakarta.inject.Inject
import java.security.Principal

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api")
class TransactionController {
    @Inject
    private lateinit var transactionService: TransactionService

    @Post("/transaction")
    fun createTransaction(@Body transactionDTO: TransactionDTO, principal: Principal) : HttpResponse<MainResponseDTO> {
        return try {
            transactionService.addTransaction(transactionDTO, principal.name)
            val response = MainResponseDTO(httpStatus = HttpStatus.CREATED, message = "Transaction created successfully")
            HttpResponse.created(response)
        } catch (e: Exception) {
            val response = MainResponseDTO(httpStatus = HttpStatus.INTERNAL_SERVER_ERROR, message = e.message.toString())
            HttpResponse.serverError(response)
        }
    }
}