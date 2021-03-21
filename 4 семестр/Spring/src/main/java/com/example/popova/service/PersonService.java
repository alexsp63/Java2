package com.example.popova.service;

import com.example.popova.entity.Person;
import com.example.popova.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonService {

    @Autowired //автоматич создает данный объект
    private PersonRepository personRepository;


    public List<Person> findAll(){
        return personRepository.findAll();
    }


    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person update(Person person, Person personFromDB) {
        BeanUtils.copyProperties(person, personFromDB, "id");
        return personRepository.save(personFromDB);
    }

    public boolean delete(Person person) {
        if (person != null){
            personRepository.delete(person);
            return true;
        }
        return false;
    }

}
