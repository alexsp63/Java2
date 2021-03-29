package com.popovapi193kr.popova.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users") //потому что postgre ругается на user
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоматически генерируется
    private int id;

    //пусть колонки в таблице так и называются
    private String login;
    private String lastName;
    private String firstName;
    private String middleName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    //общие для всех сущностей атрибуты
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updatedDate;

    //у каждого пользователя есть определённые задания, как я поняла, соответвенно ссылаюсь на поле user
    //в Task, полученное в результате ManyToOne
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", creationDate=" + creationDate +
                ", updatedDate=" + updatedDate +
                ", tasks=" + tasks +
                '}';
    }
}

