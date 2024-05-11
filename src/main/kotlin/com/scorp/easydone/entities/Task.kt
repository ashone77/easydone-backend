package com.scorp.easydone.entities

import jakarta.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "easydone_task", schema = "easydone")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 2, max = 50, message = "Title must be between 2 and 50 characters")
    val title: String,

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    val description: String,

    val status: String,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: Customer
): BaseEntity()
