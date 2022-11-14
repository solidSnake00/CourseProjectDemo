package com.example.projectcourse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
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

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<PlanRegistration> planRegistrationList = new java.util.ArrayList<>();
}
