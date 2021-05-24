package com.geekshirt.shippingservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Shipment extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "TRACKING_ID")
    private String trackingId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PROVIDER")
    private String provider;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "SHIPPING_DATE")
    private Date shippingDate;

    @Column(name = "DELIVERED_DATE")
    private Date deliveredDate;

    @Column(name = "RECEIPT_NAME")
    private String receiptName;

    @Column(name = "RECEIPT_EMAIL")
    private String receiptEmail;

    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;
}
