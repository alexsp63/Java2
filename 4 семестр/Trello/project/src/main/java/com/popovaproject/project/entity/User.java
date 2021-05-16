package com.popovaproject.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "s_user")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    @NotNull
    private String login;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String middleName;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Role_ role;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Status_ status;

    @NotNull
    private String passwordHash;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "developer")
    @JsonBackReference(value = "1")
    private Set<Task> developerTask;

    @OneToMany(mappedBy = "analyst")
    @JsonBackReference(value = "2")
    private Set<Task> analystTask;

    @OneToMany(mappedBy = "tester")
    @JsonBackReference(value = "3")
    private Set<Task> testerTask;

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getLogin() {
        return login;
    }

    public Role_ getRole() {
        return role;
    }

    public Status_ getStatus() {
        return status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
