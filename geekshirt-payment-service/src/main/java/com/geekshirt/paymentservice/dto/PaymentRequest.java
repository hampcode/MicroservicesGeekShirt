package com.geekshirt.paymentservice.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private String orderId;
    private String currency;
    private String accountId;
    private double amount;
    PaymentDetailsDto payment;
}
