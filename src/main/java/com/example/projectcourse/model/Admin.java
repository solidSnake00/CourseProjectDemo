package com.example.projectcourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin")
public class Admin extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "admin_id")
    private long id;
}
