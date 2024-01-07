package com.scorp.easydone.model

class CreateTaskRequest(
    val taskTitle:String,
    val taskDescription: String,
    val customerId: Int
) {
}