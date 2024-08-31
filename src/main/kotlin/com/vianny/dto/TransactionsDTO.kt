package com.vianny.dto

import com.vianny.enums.CategoryType
import com.vianny.enums.TransactionType
import io.micronaut.serde.annotation.Serdeable
import java.math.BigDecimal
import java.time.OffsetDateTime

@Serdeable.Serializable
data class TransactionsDTO (
    val transactionType: TransactionType,
    val amount: BigDecimal,
    val datetime: OffsetDateTime,
    val categoryType: CategoryType
)