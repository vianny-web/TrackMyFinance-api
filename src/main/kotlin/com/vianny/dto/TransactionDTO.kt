package com.vianny.dto

import com.vianny.enums.CategoryType
import com.vianny.enums.TransactionType
import io.micronaut.serde.annotation.Serdeable
import java.math.BigDecimal

@Serdeable.Deserializable
data class TransactionDTO (
    val transactionType: TransactionType,
    val amount: BigDecimal,
    val categoryType: CategoryType
)