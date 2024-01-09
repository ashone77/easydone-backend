package com.scorp.easydone.services

import com.scorp.easydone.entities.Task
import com.scorp.easydone.enums.StatusType
import com.scorp.easydone.model.CreateTaskRequest
import com.scorp.easydone.model.TaskResponse
import com.scorp.easydone.repositories.CustomerRepo
import com.scorp.easydone.repositories.TaskRepo
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class TaskService(
    @Autowired val taskRepo: TaskRepo,
    @Autowired val customerRepo: CustomerRepo
) {

    fun createTask(createTaskRequest: CreateTaskRequest): String{
        val customer = customerRepo.findById(createTaskRequest.customerId).orElseThrow {
            EntityNotFoundException("Customer Not Found")
        }
        val task = Task(
            title = createTaskRequest.taskTitle,
            description = createTaskRequest.taskDescription,
            customer = customer,
            status = StatusType.PENDING.status
        )
        taskRepo.save(task)
        return "Task Created Successfully"
    }

    fun getAllTasks(pageable: Pageable): Page<TaskResponse> {
        val tasksPage = taskRepo.findAll(pageable)
        val tasksDTO = tasksPage.content.map { TaskResponse(it.title, it.description, it.status, it.customer.username) }
        return PageImpl(tasksDTO, pageable, tasksPage.totalElements)
    }}