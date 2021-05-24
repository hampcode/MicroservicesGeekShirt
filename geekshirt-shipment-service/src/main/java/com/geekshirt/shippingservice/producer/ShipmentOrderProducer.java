package com.geekshirt.shippingservice.producer;

import com.geekshirt.shippingservice.dto.ShipmentOrderResponse;
import com.geekshirt.shippingservice.entities.Shipment;
import com.geekshirt.shippingservice.service.ShipmentService;
import com.geekshirt.shippingservice.util.enums.DateUtils;
import com.geekshirt.shippingservice.util.enums.OrderShippingStatusEnum;
import com.geekshirt.shippingservice.util.enums.StageGenerator;
import com.geekshirt.shippingservice.util.enums.converter.EntityDtoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class ShipmentOrderProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private StageGenerator stageGenerator;

    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    private EntityDtoConverter converter;

    @Autowired
    @Qualifier(value = "outbound")
    private Queue queue;

    @Scheduled(fixedDelay = 30000, initialDelay = 500)
    public void send() {
        List<Shipment> shipmentOrders = shipmentService.retrieveOrdersNotDelivered();

        for (Shipment shipment : shipmentOrders) {
            String newStage = stageGenerator.getNextStage(shipment.getStatus());
            shipment.setStatus(newStage);

            if (newStage.equals(OrderShippingStatusEnum.SHIPPED.name())) {
                shipment.setShippingDate(new Date());
            }
            else if (newStage.equals(OrderShippingStatusEnum.DELIVERED.name())) {
                shipment.setDeliveredDate(DateUtils.addDays(shipment.getShippingDate(), 1));
            }

            shipmentService.updateShipment(shipment);

            ShipmentOrderResponse shipmentResponse = new ShipmentOrderResponse(shipment.getOrderId(),
                    shipment.getReceiptName(),
                    shipment.getReceiptEmail(),
                    shipment.getTrackingId(),
                    newStage,
                    converter.convertToDto(shipment.getAddress()),
                    shipment.getShippingDate(),
                    shipment.getDeliveredDate());

            this.template.convertAndSend(queue.getName(), shipmentResponse);
            log.info(" [x] Sent: {}", shipmentResponse);
        }
    }
}
