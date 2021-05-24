package com.geekshirt.shippingservice.dto;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Component
public class ProviderSelector {
    Map<Integer, String> providerMap;
    private String DEFAULT_PROVIDER = "US Postal Service.";

    public ProviderSelector() {
        providerMap = new HashMap<>();
        providerMap.put(1, "UPS Inc.");
        providerMap.put(2, "XPO Logistics");
        providerMap.put(3, "FedEx Corp.");
        providerMap.put(4, "DHL");
        providerMap.put(5, "US Postal Service.");
    }

    public String select() {
        Random rand = new Random();
        int index = rand.nextInt(providerMap.size()) + 1;
        return providerMap.getOrDefault(index, DEFAULT_PROVIDER);
    }

    public String generateTrackingId() {
        return UUID.randomUUID().toString();
    }
}
