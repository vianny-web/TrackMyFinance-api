package com.vianny.services

import com.vianny.dto.TransactionDTO
import com.vianny.enums.CategoryType
import com.vianny.models.Transaction
import com.vianny.models.User
import com.vianny.repositories.TransactionRepository
import com.vianny.repositories.UserRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
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

    fun getTransactionByCategory (login: String, page: Int, size: Int, category: CategoryType?) : Page<Transaction> {
        val user: Optional<User> = userRepository.findByLogin(login)
        val pageable = Pageable.from(page, size)

        return if (category != null) {
            transactionRepository.findByUserAndCategoryType(user.get(), category, pageable)
        } else {
            transactionRepository.findByUser(user.get(), pageable)
        }

    }
}