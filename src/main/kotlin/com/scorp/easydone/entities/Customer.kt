package com.scorp.easydone.entities

import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.springframework.data.annotation.Id

@Entity
@Table(name="easydone_customer", schema = "easydone")
data class Customer(
    @Id
    val username: String,
    val password: String,
    val emailId: String,
    val firstName: String,
    val lastName: String,
    val Task: List<Task>? = null
)
