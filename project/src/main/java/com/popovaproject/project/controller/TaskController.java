package com.popovaproject.project.controller;

import com.popovaproject.project.entity.Task;
import com.popovaproject.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value="/api/task")
    private ResponseEntity<?> create(@RequestBody Task task){
        Task newTask = taskService.create(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/task")
    private ResponseEntity<List<Task>> readAll(){
        final List<Task> taskList = taskService.findAll();
        return taskList != null && !taskList.isEmpty()
                ? new ResponseEntity<>(taskList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "api/task/{id}")
    public ResponseEntity<Task> getOne(@PathVariable(name = "id") Task task) {
        final Task currentTask = task;
        return task != null
                ? new ResponseEntity<>(currentTask, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "api/task/{id}")
    public ResponseEntity<?> put(@PathVariable(name = "id") Task taskFromDB,
                                 @RequestBody Task task) {
        Task updatedTask = taskService.update(task, taskFromDB);
        if (updatedTask != null) {
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
