package com.popovaproject.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "s_task")
@NoArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    private String title;
    private String text;

    @ManyToOne
    @JoinColumn(name = "analyst_id")
    private User analyst;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private User developer;

    @ManyToOne
    @JoinColumn(name = "tester_id")
    private User tester;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = true)
    private StatusTask statusTask;

}
