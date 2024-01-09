package com.scorp.easydone.controller

import com.scorp.easydone.model.CreateTaskRequest
import com.scorp.easydone.model.TaskResponse
import com.scorp.easydone.services.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/")
    fun getAllTasks(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): ResponseEntity<Page<TaskResponse>> {
        val tasksPage = taskService.getAllTasks(PageRequest.of(page, size))
        return ResponseEntity.ok(tasksPage)
    }}