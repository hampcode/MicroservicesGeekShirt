package com.geekshirt.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "CREDIT_CARD")
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME_ON_CARD")
    private String nameOnCard;
    @Column(name = "NUMBER_ON_CARD")
    private String number;
    @Column(name = "CARD_TYPE")
    private String cardType;
    @Column(name = "EXP_MONTH")
    private String expirationMonth;
    @Column(name = "EXP_YEAR")
    private String expirationYear;
    @Column(name = "CCV")
    private String ccv;
}
