package com.scorp.easydone.entities

import com.scorp.easydone.enums.EasyDoneException
import com.scorp.easydone.enums.ErrorCodes
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
) : BaseEntity() {
    fun validate() {
        validateUsername()
        validatePassword()
    }

    private fun validateUsername() {
        if (username.isBlank()) {
            throw EasyDoneException(ErrorCodes.NO_USERNAME_INPUT.message,ErrorCodes.NO_USERNAME_INPUT.errorCode)
        }
    }

    private fun validatePassword() {
        if (password.isBlank()) {
            throw EasyDoneException(ErrorCodes.NO_PASSWORD_INPUT.message,ErrorCodes.NO_PASSWORD_INPUT.errorCode)
        }
        if (password.length < 8) {
            throw EasyDoneException(ErrorCodes.INVALID_PASSWORD_LENGTH.message,ErrorCodes.INVALID_PASSWORD_LENGTH.errorCode)
        }
    }
}
