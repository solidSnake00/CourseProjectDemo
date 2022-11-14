package com.example.projectcourse.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@AllArgsConstructor

@Getter
@Setter
@ToString
@Embeddable
@RequiredArgsConstructor
@EqualsAndHashCode
public class PlanRegistrationKey implements Serializable {

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "plan_id")
    private long planId;
}
