// RazorpayService.java
package com.backend.luciddecorf.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {

    private RazorpayClient client;

    @Value("${razorpay.key}")
    private String key;

    @Value("${razorpay.secret}")
    private String secret;

    public RazorpayService() throws Exception {
        this.client = new RazorpayClient(key, secret);
    }

    public Order createOrder(double amount, String currency) throws Exception {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // amount in the smallest currency unit
        orderRequest.put("currency", currency);
        orderRequest.put("payment_capture", 1); // auto capture

        return client.Orders.create(orderRequest);
    }
}