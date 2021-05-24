package com.geekshirt.customerservice.dto;

import lombok.Data;

@Data
public class CreditCardDto {
    private Long id;
    private String nameOnCard;
    private String number;
    private String type;
    private String expirationMonth;
    private String expirationYear;
    private String ccv;
}
