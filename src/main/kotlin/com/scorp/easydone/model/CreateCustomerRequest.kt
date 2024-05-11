package com.scorp.easydone.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class CreateCustomerRequest(
    @NotBlank(message = "Username cannot be empty")
    @Pattern(
        regexp = "^[a-zA-Z0-9_-]{3,16}$",
        message = "Username must be between 3 and 16 characters long and can only contain letters, numbers, underscores, and hyphens."
    )
    @Size(min = 3, max = 16)
    val username: String,

    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters long")
    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
        message = "Password must meet complexity requirements"
    )
    val password: String,

    @Email
    val emailId: String,

    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    @Pattern(regexp = "^[a-zA-Z'-]+$", message = "First name can only contain letters, hyphens, and apostrophes")
    val firstName: String,

    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    @Pattern(regexp = "^[a-zA-Z'-]+$", message = "Last name can only contain letters, hyphens, and apostrophes")
    val lastName: String
)