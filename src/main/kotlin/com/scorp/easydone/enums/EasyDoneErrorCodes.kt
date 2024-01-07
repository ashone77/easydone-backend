package com.scorp.easydone.enums

class EasyDoneException(message: String?,val errorCode: String?): RuntimeException(message)
object ErrorCodes {
    val INVALID_PASSWORD_LENGTH = EasyDoneException("Password length should be atleast 8.", "002")
    val NO_PASSWORD_INPUT = EasyDoneException("Password cannot be blank.", "003")
    val NO_USERNAME_INPUT = EasyDoneException("Username cannot be blank.", "004")
}