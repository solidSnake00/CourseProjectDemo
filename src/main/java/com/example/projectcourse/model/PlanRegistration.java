package com.example.projectcourse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Plan_Registration")
public class PlanRegistration {

    @EmbeddedId
    private PlanRegistrationKey id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @MapsId("planId")
    @JoinColumn(name = "plan_id")
    @JsonIgnore
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlanRegistration that = (PlanRegistration) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\nPlanRegistration{" +
                "plan id= "+id.getPlanId()+
                ", customer id= "+id.getCustomerId()+
                ", planName= "+plan.getName()+
                ", customerName= "+customer.getUserName()+
                ", totalPrice=" + String.valueOf(totalPrice) +
                ", paymentMethod=" + paymentMethod +
                ", purchaseDate=" + String.valueOf(purchaseDate) +
                ", expirationDate=" + String.valueOf(expirationDate) +
                '}';
    }
}
