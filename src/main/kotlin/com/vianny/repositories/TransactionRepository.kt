package com.vianny.repositories

import com.vianny.models.Transaction
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
interface TransactionRepository : CrudRepository<Transaction, Long> {

}