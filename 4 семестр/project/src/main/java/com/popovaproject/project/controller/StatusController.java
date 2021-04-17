package com.popovaproject.project.controller;

import com.popovaproject.project.entity.Status;
import com.popovaproject.project.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping(value="/api/status")
    private ResponseEntity<?> create(@RequestBody Status status){
        Status newStatus = statusService.create(status);
        return new ResponseEntity<>(newStatus, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/status")
    private ResponseEntity<List<Status>> readAll(){
        final List<Status> statusList = statusService.findAll();
        return statusList != null && !statusList.isEmpty()
                ? new ResponseEntity<>(statusList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "api/status/{id}")
    public ResponseEntity<Status> getOne(@PathVariable(name = "id") Status status) {
        final Status currentStatus = status;
        return status != null
                ? new ResponseEntity<>(currentStatus, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "api/status/{id}")
    public ResponseEntity<?> put(@PathVariable(name = "id") Status statusFromDB,
                                 @RequestBody Status status) {
        Status updatedStatus = statusService.update(status, statusFromDB);
        if (updatedStatus != null) {
            return new ResponseEntity<>(updatedStatus, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "api/status/{id}")
    public ResponseEntity<List<Status>> delete(@PathVariable(name = "id") Status status) {
        if (statusService.delete(status)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
