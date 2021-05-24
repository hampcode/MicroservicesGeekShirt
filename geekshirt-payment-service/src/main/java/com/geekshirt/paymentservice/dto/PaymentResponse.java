package com.geekshirt.paymentservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentResponse {
    private String orderId;
    private String accountId;
    private String transactionId;
    private String transactionStatus;
    private String authCode;
    private String method;
    private String currency;
    private String cardNumber;
    private Double totalAmount;
    private Date transactionDate;
}
