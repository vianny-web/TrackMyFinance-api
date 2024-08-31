package com.vianny.models

import com.vianny.enums.CategoryType
import com.vianny.enums.TransactionType
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.OffsetDateTime

@Entity
@Serdeable
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User?,

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction", nullable = false)
    val transactionType: TransactionType?,

    @Column(nullable = false)
    val amount: BigDecimal?,

    @Column(name = "datatime", nullable = false)
    val datetime: OffsetDateTime?,

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    val categoryType: CategoryType?
) {
    constructor() : this(null, null, null, null, OffsetDateTime.now(), null)
    constructor(
        user: User,
        transactionType: TransactionType,
        amount: BigDecimal,
        categoryType: CategoryType
    ) : this(null, user, transactionType, amount, OffsetDateTime.now(), categoryType)
}
