package com.geekshirt.shippingservice.util.enums;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StageGenerator {

    private Map<String, String> stageMap = new HashMap<>();

    public StageGenerator() {
        stageMap.put(OrderShippingStatusEnum.WAITING_FOR_MAIL_CARRIER.name(), OrderShippingStatusEnum.SHIPPED.name());
        stageMap.put(OrderShippingStatusEnum.SHIPPED.name(), OrderShippingStatusEnum.ARRIVED_FACILITY.name());
        stageMap.put(OrderShippingStatusEnum.ARRIVED_FACILITY.name(), OrderShippingStatusEnum.OUT_FOR_DELIVERY.name());
        stageMap.put(OrderShippingStatusEnum.OUT_FOR_DELIVERY.name(), OrderShippingStatusEnum.DELIVERED.name());
    }

    public String getNextStage(String currentStage) {
        return  stageMap.getOrDefault(currentStage, OrderShippingStatusEnum.SHIPPED.name());
    }
}
