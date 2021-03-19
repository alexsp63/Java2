package com.example.popova.controller;

import com.example.popova.entity.Person;
import com.example.popova.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiController {

    private final PersonService personService;

    @Autowired
    public RestApiController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value="/api/person")
    private ResponseEntity<?> create(@RequestBody Person person){
        personService.create(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/person")
    private ResponseEntity<List<Person>> readAll(){
        final List<Person> personList = personService.findAll();
        return personList != null && !personList.isEmpty()
                ? new ResponseEntity<>(personList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
