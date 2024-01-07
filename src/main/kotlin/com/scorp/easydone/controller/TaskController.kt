package com.scorp.easydone.controller

import com.scorp.easydone.model.CreateTaskRequest
import com.scorp.easydone.services.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/task/")
class TaskController(
    @Autowired val taskService: TaskService
) {

    @PostMapping("/create")
    fun createTask(
        @RequestBody createTaskRequest: CreateTaskRequest
    ): String {
      return taskService.createTask(createTaskRequest)
    }
}