package com.scorp.easydone.repositories

import com.scorp.easydone.entities.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepo: JpaRepository<Task, Int> {
}