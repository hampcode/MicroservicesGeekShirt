package com.geekshirt.paymentservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PAYMENT")
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @Column(name = "TRANSACTION_ID")
    private String transactionId;

    @Column(name = "TRANSACTION_STATUS")
    private String transactionStatus;

    @Column(name = "AUTH_CODE")
    private String authCode;

    @Column(name = "METHOD")
    private String method;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "TOTAL_AMOUNT")
    private Double totalAmount;

    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
}
