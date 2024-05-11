package com.scorp.easydone.entities

import jakarta.persistence.*

@Entity
@Table(name="easydone_customer", schema = "easydone")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    val username: String,

    val password: String,

    val emailId: String,

    val firstName: String,

    val lastName: String,
    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val tasks: List<Task>? = null
) : BaseEntity()
