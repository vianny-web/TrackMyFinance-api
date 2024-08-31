package com.vianny.repositories

import com.vianny.enums.CategoryType
import com.vianny.models.Transaction
import com.vianny.models.User
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
interface TransactionRepository : CrudRepository<Transaction, Long> {
    fun findByUserAndCategoryType(user: User, categoryType: CategoryType, pageable: Pageable): Page<Transaction>
    fun findByUser(user: User, pageable: Pageable): Page<Transaction>
}