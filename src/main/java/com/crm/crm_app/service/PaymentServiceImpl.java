package com.crm.crm_app.service;

import com.crm.crm_app.dto.PaymentDTO;
import com.crm.crm_app.model.Payment;
import com.crm.crm_app.repository.PaymentRepository;
import com.crm.crm_app.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marks this class as a Spring Service component
public class PaymentServiceImpl implements PaymentService {

    @Autowired  // Injects the PaymentRepository
    private PaymentRepository paymentRepository;

    // Create Payment
    @Override
    public Payment createPayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentMode(paymentDTO.getPaymentMode());
        payment.setUserId(paymentDTO.getUserId());
        return paymentRepository.save(payment);
    }

    // Get Payment by ID
    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    // Get all Payments
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Update Payment
    @Override
    public Payment updatePayment(Long id, PaymentDTO paymentDTO) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            payment.setAmount(paymentDTO.getAmount());
            payment.setPaymentMode(paymentDTO.getPaymentMode());
            payment.setUserId(paymentDTO.getUserId());
            return paymentRepository.save(payment);
        } else {
            return null;
        }
    }

    // Delete Payment
    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
