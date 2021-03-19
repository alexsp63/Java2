package com.example.popova.repository;

import com.example.popova.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    //поддерживает стандартные методы типа поиска по ID, вставки и т.д., но если хотим свои selectы
    //или что-то другое, то прописываем их здесь, и уже в PersonService реализуем это всё

    //void create(Person person);
    //public List<Person> findPeopleBy;
}
