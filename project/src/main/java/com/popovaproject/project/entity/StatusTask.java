package com.popovaproject.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "s_status_task")
@NoArgsConstructor
@Data
public class StatusTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @OneToMany(mappedBy = "statusTask")
    @JsonBackReference
    private Set<Task> tasks;
}
