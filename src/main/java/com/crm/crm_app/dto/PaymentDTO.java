package com.crm.crm_app.dto;

import lombok.Data;

@Data  // Lombok generates getter/setter, equals, hashCode, toString
public class PaymentDTO {

    private Double amount;        // Payment amount

    private String paymentMode;   // Payment type or method

    private Long userId;          // Link to user
}
