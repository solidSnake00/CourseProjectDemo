package com.example.projectcourse.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Customer")
public class Customer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "costumer_id")
    private long id;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "ip_address")
    private String IPAddress;
    @Column(name = "customer_status")
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;
    @Column(name = "verified_email")
    private boolean verifiedEmail;

    @OneToMany(mappedBy = "customer")
    private List<PlanRegistration> planRegistrationList;
}
