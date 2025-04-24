package com.crm.crm_app.repository;

import com.crm.crm_app.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Tells Spring this is a DB component.
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Custom queries can go here later (optional).
}
