package com.backend.luciddecorf.controller;

import com.backend.luciddecorf.service.RazorpayService;
import com.razorpay.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final RazorpayService razorpayService;

    @Autowired
    public PaymentController(RazorpayService razorpayService) {
        this.razorpayService = razorpayService;
    }

    @PostMapping("/createOrder")
    public String createOrder(@RequestParam double amount, @RequestParam String currency) {
        try {
            Order order = razorpayService.createOrder(amount, currency);
            return order.toString();
        } catch (Exception e) {
            return "Error creating order: " + e.getMessage();
        }
    }
}