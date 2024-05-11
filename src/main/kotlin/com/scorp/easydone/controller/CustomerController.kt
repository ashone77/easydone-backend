package com.scorp.easydone.controller

import com.scorp.easydone.model.CreateCustomerRequest
import com.scorp.easydone.services.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/customer/")
class CustomerController(
    @Autowired val customerService: CustomerService
) {

    @PostMapping("/create")
    fun createCustomer(
        @Valid @RequestBody createCustomerRequest: CreateCustomerRequest
    ): String {
        return customerService.createCustomer(createCustomerRequest)
    }

}