package com.geekshirt.paymentservice.util;

import com.geekshirt.paymentservice.domain.PaymentConfirmation;
import com.geekshirt.paymentservice.dto.PaymentDetailsDto;
import com.geekshirt.paymentservice.service.AuthorizerResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Slf4j
@Component
public class Authorizer {

    private final String CREDIT_CARD_MASK = "xxxx-xxxx-xxxx-####";

    public PaymentConfirmation processPayment(PaymentDetailsDto payment) {
        String maskedCreditCard = maskCardNumber(payment.getCardNumber(), CREDIT_CARD_MASK);

        log.info("Processing payment for CC: {}", maskedCreditCard);

        int result = getRandomNumberInRange(0, 1);

        String statusResult = result > 0 ? AuthorizerResult.APPROVED.name()
                : AuthorizerResult.DENIED.name();

        log.info("Response: {}", statusResult);
        return new PaymentConfirmation(UUID.randomUUID().toString(), statusResult);
    }

    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public String maskCardNumber(String cardNumber, String mask) {

        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }

        return maskedNumber.toString();
    }
}
