package com.scorp.easydone.entities

import jakarta.persistence.*

@Entity
@Table(name = "easydone_task", schema = "easydone")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val title: String,
    val description: String?,
    val status: String,
    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: Customer
): BaseEntity()
