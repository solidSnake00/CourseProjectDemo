package com.example.projectcourse.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private long id;
    @Column(name = "first_name", length = 25)
    private String firstName;
    @Column(name = "last_name", length = 25)
    private String lastName;
    @Column(name = "username", nullable = false, unique = true, length = 35)
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
