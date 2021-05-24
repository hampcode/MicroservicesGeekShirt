package com.geekshirt.shippingservice.consumer;

import com.geekshirt.shippingservice.dto.ShipmentOrderRequest;
import com.geekshirt.shippingservice.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShipmentOrderConsumer {

    @Autowired
    private ShipmentService shipmentService;

    @RabbitListener(queues = "INBOUND_SHIPMENT_ORDER")
    public void receive(final ShipmentOrderRequest in) {
        log.debug(" [x] Received '" + in.getOrderId() + "'");
        shipmentService.createShipment(in);
    }
}
