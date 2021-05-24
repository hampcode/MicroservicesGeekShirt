package com.geekshirt.paymentservice.service;

import com.geekshirt.paymentservice.domain.Confirmation;
import com.geekshirt.paymentservice.domain.PaymentConfirmation;
import com.geekshirt.paymentservice.dto.PaymentRequest;
import com.geekshirt.paymentservice.entities.Payment;
import com.geekshirt.paymentservice.repositories.PaymentRepository;
import com.geekshirt.paymentservice.util.Authorizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Authorizer authorizer;

    public Confirmation authorize(PaymentRequest request) {
        log.info("Authorizing Payment: {}", request.toString());

        PaymentConfirmation paymentConfirmation = authorizer.processPayment(request.getPayment());
        String transactionId = UUID.randomUUID().toString();

        Payment payment = Payment.builder()
                            .transactionId(transactionId)
                            .orderId(request.getOrderId())
                            .transactionStatus(paymentConfirmation.getStatus())
                            .authCode(paymentConfirmation.getAuthCode())
                            .accountId(request.getAccountId())
                            .currency(request.getCurrency())
                            .cardNumber(request.getPayment().getCardNumber())
                            .totalAmount(request.getAmount())
                            .method(request.getPayment().getMethod())
                            .transactionDate(new Date())
                            .build();

        Payment paymentResult = paymentRepository.save(payment);

        return new Confirmation(paymentResult.getOrderId(), paymentResult.getAccountId(),
                    paymentResult.getTransactionId(), paymentResult.getTransactionStatus(),
                    paymentResult.getAuthCode(), paymentResult.getTransactionDate());
    }

    public List<Payment> findPaymentsByTransactionId(String transactionId) {
        return paymentRepository.findByTransactionId(transactionId);
    }

    public List<Payment> findPaymentsByAccountId(String accountId) {
        return paymentRepository.findByAccountId(accountId);
    }

    public List<Payment> findPaymentsByOrderId(String orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
