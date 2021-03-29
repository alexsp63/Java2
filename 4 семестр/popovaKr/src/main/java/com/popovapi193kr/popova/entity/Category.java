package com.popovapi193kr.popova.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //общие для всех сущностей атрибуты
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updatedDate;

    //джава делает многие ко многим и создаёт доп объект пересечения tasks_categories
    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    private List<Task> tasks;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", updatedDate=" + updatedDate +
                ", tasks=" + tasks +
                '}';
    }
}

