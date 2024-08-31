package com.vianny.models

import jakarta.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue
    val id: Long?,

    @Column(unique = true, nullable = false)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val transactions: MutableSet<Transaction> = HashSet()
) {
    constructor() : this(null, "", "")
}