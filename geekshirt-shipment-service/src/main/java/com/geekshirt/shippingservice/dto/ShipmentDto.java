package com.geekshirt.shippingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShipmentDto {
    private String orderId;

    private String receiptName;

    private String receiptEmail;

    private String trackingId;

    private String status;

    private String provider;

    private double price;

    private Date shippingDate;

    private Date deliveredDate;

    private AddressDto address;
}
