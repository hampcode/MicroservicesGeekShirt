package com.geekshirt.shippingservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class ShipmentConfig {

    @Qualifier(value = "inbound")
    @Bean
    public Queue inboundShipmentOrder() {
        return new Queue("INBOUND_SHIPMENT_ORDER", false, false, false);
    }

    @Qualifier(value = "outbound")
    @Bean
    public Queue outboundShipmentOrder() {
        return new Queue("OUTBOUND_SHIPMENT_ORDER");
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
