package com.example.projectcourse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Plan_Registration")
public class PlanRegistration {

    @EmbeddedId
    private PlanRegistrationKey id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("planId")
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

}
