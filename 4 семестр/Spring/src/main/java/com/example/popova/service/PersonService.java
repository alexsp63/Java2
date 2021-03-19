package com.example.popova.service;

import com.example.popova.entity.Person;
import com.example.popova.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonService {

    private static final AtomicInteger personId = new AtomicInteger();

    @Autowired //автоматич создает данный объект
    private PersonRepository personRepository;


    public List<Person> findAll(){
        return personRepository.findAll();
    }


    public Person create(Person person){

        final int lastPersonId = personId.incrementAndGet();
        person.setId((long) lastPersonId);
        personRepository.save(person);
        return person;
    }

    public Person read(int id) {
        return personRepository.findById(id);
    }

    public boolean update(Person person, int id) {
        Person thisPerson = personRepository.findById(id);
        if (thisPerson == null){
            return false; //нет такого пёрсона
        }
        personRepository.delete(thisPerson);  //удалить старую инфу
        personRepository.save(person);        //добавить новую
        return true;
    }

    public boolean delete(int id) {
        Person thisPerson = personRepository.findById(id);
        if (thisPerson == null) {
            return false;
        }
        personRepository.delete(thisPerson);
        return true;
    }

}
