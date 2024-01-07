package com.scorp.easydone.repositories

import com.scorp.easydone.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepo: JpaRepository<Customer, Int> {

}