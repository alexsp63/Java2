package com.example.popova.service;

import com.example.popova.entity.Person;
import com.example.popova.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired //автоматич создает данный объект
    private PersonRepository personRepository;


    public List<Person> findAll(){
        return personRepository.findAll();
    }


    public void create(Person person){
        personRepository.save(person);
    }
}
