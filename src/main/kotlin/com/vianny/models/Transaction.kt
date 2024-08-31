package com.vianny.models

import com.vianny.enums.CategoryType
import com.vianny.enums.TransactionType
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.OffsetDateTime

@Entity
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User?,

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    val transactionType: TransactionType?,

    @Column(nullable = false)
    val amount: BigDecimal?,

    @Column(name = "datatime", nullable = false)
    val datetime: OffsetDateTime?,

    @Enumerated(EnumType.STRING)
    @Column(name = "category_type", nullable = false)
    val categoryType: CategoryType?
) {
    constructor() : this(null, null, null, null, null, null)
}