package com.popovaproject.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "s_role")
@NoArgsConstructor
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<User> users;

}
