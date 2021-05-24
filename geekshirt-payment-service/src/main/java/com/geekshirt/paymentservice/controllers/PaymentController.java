package com.geekshirt.paymentservice.controllers;

import com.geekshirt.paymentservice.domain.Confirmation;
import com.geekshirt.paymentservice.dto.PaymentRequest;
import com.geekshirt.paymentservice.dto.PaymentResponse;
import com.geekshirt.paymentservice.entities.Payment;
import com.geekshirt.paymentservice.service.PaymentService;
import com.geekshirt.paymentservice.util.PaymentTransferConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentTransferConverter converter;

    @PostMapping(value = "/authorize")
    public ResponseEntity<Confirmation> authorize(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.authorize(paymentRequest), HttpStatus.OK);
    }

    @GetMapping(value = "/transaction/{transactionId}")
    public ResponseEntity<List<PaymentResponse>> findPaymentsByTransactionId(@PathVariable("transactionId") String transactionId) {
        List<Payment> payments = paymentService.findPaymentsByTransactionId(transactionId);
        return new ResponseEntity<>(converter.convertListPaymentToDto(payments), HttpStatus.OK);
    }

    @GetMapping(value = "/order/{orderId}")
    public ResponseEntity<List<PaymentResponse>> findPaymentsByOrderId(@PathVariable("orderId") String orderId) {
        List<Payment> payments = paymentService.findPaymentsByOrderId(orderId);
        return new ResponseEntity<>(converter.convertListPaymentToDto(payments), HttpStatus.OK);
    }

    @GetMapping(value = "/account/{accountId}")
    public ResponseEntity<List<PaymentResponse>> findPaymentsByAccountId(@PathVariable("accountId") String accountId) {
        List<Payment> payments = paymentService.findPaymentsByAccountId(accountId);
        return new ResponseEntity<>(converter.convertListPaymentToDto(payments), HttpStatus.OK);
    }
}
