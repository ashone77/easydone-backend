package com.scorp.easydone.model

class CreateCustomerRequest(
    val username: String,
    val password: String,
    val emailId: String,
    val firstName: String,
    val lastName: String
)