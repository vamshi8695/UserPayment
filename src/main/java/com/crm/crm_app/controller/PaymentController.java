package com.crm.crm_app.controller;

import com.crm.crm_app.dto.PaymentDTO;
import com.crm.crm_app.model.Payment;
import com.crm.crm_app.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // This tells Spring to handle HTTP requests here
@RequestMapping("/api/payments")  // Base path for all payment APIs
@Slf4j
public class PaymentController {

    @Autowired  // Inject the PaymentService
    private PaymentService paymentService;

    // Create a new Payment
    @PostMapping
    public Payment createPayment(@RequestBody PaymentDTO paymentDTO) {
        log.info("payment is being processed");
        return paymentService.createPayment(paymentDTO);
    }

    // Get Payment by ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        log.info("payment is being made");
        return paymentService.getPaymentById(id);
    }

    // Get all Payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Update an existing Payment
    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO) {
        return paymentService.updatePayment(id, paymentDTO);
    }

    // Delete a Payment by ID
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment deleted successfully!";
    }
}
