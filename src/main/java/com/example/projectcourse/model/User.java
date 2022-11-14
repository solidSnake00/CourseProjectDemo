package com.example.projectcourse.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
    @Email(message = "Enter a valid email")
    private String email;
    @Column(name = "password")
    @Size(min = 5, message = "Password should at least contains 5 characters")
    private String password;
}
