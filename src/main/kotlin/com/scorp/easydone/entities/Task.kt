package com.scorp.easydone.entities

import com.scorp.easydone.enums.StatusType

data class Task(
    val title: String,
    val description: String?,
    val status: StatusType,
)
