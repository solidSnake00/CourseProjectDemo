package com.example.projectcourse.repository;

import com.example.projectcourse.model.PlanRegistration;
import com.example.projectcourse.model.PlanRegistrationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRegistrationRepository extends JpaRepository<PlanRegistration, PlanRegistrationKey> {
}