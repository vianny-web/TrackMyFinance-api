package com.vianny.models

import jakarta.persistence.*

@Table(name = "user")
@Entity
data class User(
    @Id
    @GeneratedValue
    val id: Long?,

    @Column(unique = true, nullable = false)
    val login: String,

    @Column(nullable = false)
    val password: String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val transactions: MutableSet<Transaction> = HashSet()
) {
    constructor() : this(null, "", "")
}