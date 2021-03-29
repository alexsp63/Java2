package com.popovapi193kr.popova.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate completeDate;

    private boolean isComplete;

    //общие для всех сущностей атрибуты
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updatedDate;

    //тут, как я поняла, каждое задание назначено именно одному пользователю, так что у него появляется поле айди его владельца
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //каждое задание может иметь несколько категорий
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categories")
    private List<Category> categories;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", completeDate=" + completeDate +
                ", isComplete=" + isComplete +
                ", creationDate=" + creationDate +
                ", updatedDate=" + updatedDate +
                ", user=" + user +
                ", categories=" + categories +
                '}';
    }
}