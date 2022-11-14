package com.example.projectcourse.repository;

import com.example.projectcourse.model.PlanRegistration;
import com.example.projectcourse.model.PlanRegistrationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRegistrationRepository extends JpaRepository<PlanRegistration, PlanRegistrationKey> {

    @Query(value="SELECT * FROM plan_registration", nativeQuery = true)
    public List<PlanRegistration> getAllRegistrationsSQL();
}