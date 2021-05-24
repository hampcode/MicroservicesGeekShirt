package com.geekshirt.customerservice.dto;

import com.geekshirt.customerservice.util.AccountStatus;
import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private AddressDto address;
    private CustomerDto customer;
    private CreditCardDto creditCard;
    private AccountStatus status;
}
