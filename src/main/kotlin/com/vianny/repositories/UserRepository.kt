package com.vianny.repositories

import com.vianny.models.User
import io.micronaut.context.annotation.Executable
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.util.*

@JdbcRepository(dialect = Dialect.POSTGRES)
interface UserRepository : CrudRepository<User, Long> {
    @Executable
    fun findByLogin(username: String) : Optional<User>
}