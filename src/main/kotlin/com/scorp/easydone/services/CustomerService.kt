package com.scorp.easydone.services

import com.scorp.easydone.entities.Customer
import com.scorp.easydone.model.CreateCustomerRequest
import com.scorp.easydone.repositories.CustomerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService(
    @Autowired val customerRepo: CustomerRepo
) {

    fun createCustomer(request: CreateCustomerRequest): String {
        val customer = Customer(
            emailId = request.emailId,
            username = request.username,
            password = request.password,
            firstName = request.firstName,
            lastName = request.lastName
        )
        customer.validate()
        customerRepo.save(customer)
        return "Customer Created Successfully."
    }
}