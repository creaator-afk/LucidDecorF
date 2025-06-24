package com.backend.luciddecorf.controller;

import com.backend.luciddecorf.model.InteriorDesign;
import com.backend.luciddecorf.service.RazorpayService;
import com.razorpay.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final RazorpayService razorpayService;

    @Autowired
    public PaymentController(RazorpayService razorpayService) {
        this.razorpayService = razorpayService;
    }

    @PostMapping(value = "/createOrder")
    public ResponseEntity<String> createOrder(@RequestParam double amount, @RequestParam String currency) {
        try {
            Order order = razorpayService.createOrder(amount, currency);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(order.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json")
                    .body("{\"error\": \"Error creating order: " + e.getMessage() + "\"}");
        }
    }
}