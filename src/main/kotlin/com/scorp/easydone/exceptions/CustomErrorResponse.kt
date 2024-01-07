package com.scorp.easydone.exceptions

import java.time.LocalDateTime

data class CustomErrorResponse(
    val timestamp: LocalDateTime,
    val status: Int,
    val error: String,
    val message: String?,
    val errorCode: String?
)