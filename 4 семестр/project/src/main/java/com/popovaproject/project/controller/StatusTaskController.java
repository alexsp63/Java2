package com.popovaproject.project.controller;

import com.popovaproject.project.entity.StatusTask;
import com.popovaproject.project.service.StatusTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusTaskController {

    private final StatusTaskService statusTaskService;

    @Autowired
    public StatusTaskController(StatusTaskService statusTaskService) {
        this.statusTaskService = statusTaskService;
    }

    @PostMapping(value="/api/statusTask")
    private ResponseEntity<?> create(@RequestBody StatusTask statusTask){
        StatusTask newStatusTask = statusTaskService.create(statusTask);
        return new ResponseEntity<>(newStatusTask, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/statusTask")
    private ResponseEntity<List<StatusTask>> readAll(){
        final List<StatusTask> statusTaskList = statusTaskService.findAll();
        return statusTaskList != null && !statusTaskList.isEmpty()
                ? new ResponseEntity<>(statusTaskList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "api/statusTask/{id}")
    public ResponseEntity<StatusTask> getOne(@PathVariable(name = "id") StatusTask statusTask) {
        final StatusTask currentStatusTask = statusTask;
        return statusTask != null
                ? new ResponseEntity<>(currentStatusTask, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "api/statusTask/{id}")
    public ResponseEntity<?> put(@PathVariable(name = "id") StatusTask statusTaskFromDB,
                                 @RequestBody StatusTask statusTask) {
        StatusTask updatedStatusTask = statusTaskService.update(statusTask, statusTaskFromDB);
        if (updatedStatusTask != null) {
            return new ResponseEntity<>(updatedStatusTask, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "api/statusTask/{id}")
    public ResponseEntity<List<StatusTask>> delete(@PathVariable(name = "id") StatusTask statusTask) {
        if (statusTaskService.delete(statusTask)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
