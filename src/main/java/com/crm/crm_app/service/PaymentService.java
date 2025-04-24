package com.crm.crm_app.service;

import com.crm.crm_app.dto.PaymentDTO;
import com.crm.crm_app.model.Payment;

import java.util.List;

public interface PaymentService {

    Payment createPayment(PaymentDTO paymentDTO);

    Payment getPaymentById(Long id);

    List<Payment> getAllPayments();

    Payment updatePayment(Long id, PaymentDTO paymentDTO);

    void deletePayment(Long id);
}
