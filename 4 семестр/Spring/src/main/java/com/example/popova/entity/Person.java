package com.example.popova.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Table(name="")
@Data //подиягивает get и set
@NoArgsConstructor //конструктор без аргментов
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоматически генерируется
    private Long id;

    //здесь не обязательно аннотацию пихать перед каждым атрибутом, но можно напсиать @Column(name=)
    private String firstName;
    private String lastName;
    private String city;
    private String street;


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
