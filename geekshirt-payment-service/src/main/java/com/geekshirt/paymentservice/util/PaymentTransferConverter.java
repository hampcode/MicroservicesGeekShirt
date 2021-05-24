package com.geekshirt.paymentservice.util;

import com.geekshirt.paymentservice.dto.PaymentResponse;
import com.geekshirt.paymentservice.entities.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentTransferConverter {
    @Autowired
    private ModelMapper modelMapper;

    public List<PaymentResponse> convertListPaymentToDto(List<Payment> payments) {

        if (payments == null || payments.isEmpty()) {
            return new ArrayList<>();
        }

        return payments.stream().map(payment -> convertPaymentToDto(payment))
                .collect(Collectors.toList());
    }

    public PaymentResponse convertPaymentToDto(Payment payment) {

        if (payment == null) {
            return new PaymentResponse();
        }

        return modelMapper.map(payment, PaymentResponse.class);
    }
}
