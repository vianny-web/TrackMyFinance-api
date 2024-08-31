package com.vianny.services

import com.vianny.dto.TransactionDTO
import com.vianny.models.Transaction
import com.vianny.models.User
import com.vianny.repositories.TransactionRepository
import com.vianny.repositories.UserRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.Optional

@Singleton
class TransactionService {
    @Inject
    private lateinit var userRepository: UserRepository
    @Inject
    private lateinit var transactionRepository: TransactionRepository

    fun addTransaction (transactionDTO: TransactionDTO, login: String) {
        val user: Optional<User> = userRepository.findByLogin(login)
        val transactionEntity = Transaction(user.get(), transactionDTO.transactionType,
            transactionDTO.amount, transactionDTO.categoryType)

        transactionRepository.save(transactionEntity)
    }
}