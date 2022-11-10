package com.example.projectcourse.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class PlanRegistrationKey implements Serializable {

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "plan_id")
    private long planId;
}
