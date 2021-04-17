package com.popovaproject.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "s_status")
@NoArgsConstructor
@Data
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    private String name;

    @OneToMany(mappedBy = "status")
    @JsonBackReference
    private Set<StatusTask> statusTasks;

}
