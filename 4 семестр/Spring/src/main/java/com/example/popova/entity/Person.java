package com.example.popova.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    private String street;
    private String city;
    private String postalCode;
    private LocalDate birthDay;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }


}
