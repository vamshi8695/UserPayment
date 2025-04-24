package com.crm.crm_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data  // Lombok will auto-generate getters, setters, equals, hashCode, toString
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    private Double amount;        // Payment amount

    private String paymentMode;   // E.g. "Credit Card", "Cash", "PayPal"

    private Long userId;          // Foreign key: which User this payment belongs to
}
