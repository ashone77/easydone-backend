package com.scorp.easydone.model

import com.scorp.easydone.enums.Codes
import org.aspectj.apache.bcel.classfile.Code

class BaseResponse<T>(
    val data: T? = null,
    val status: String? = null,
    val errorCode: Int? = null
)