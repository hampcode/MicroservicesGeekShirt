package com.geekshirt.shippingservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShipmentOrderResponse {
    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("receiptEmail")
    private String receiptEmail;

    @JsonProperty("trackingId")
    private String trackingId;

    @JsonProperty("shippingStatus")
    private String shippingStatus;

    @JsonProperty("address")
    private AddressDto address;

    @JsonProperty("shippingDate")
    private Date shippingDate;

    @JsonProperty("deliveredDate")
    private Date deliveredDate;
}
