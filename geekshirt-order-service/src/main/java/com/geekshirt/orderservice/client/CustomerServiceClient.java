package com.geekshirt.orderservice.client;

import com.geekshirt.orderservice.config.OrderServiceConfig;
import com.geekshirt.orderservice.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CustomerServiceClient {
    private RestTemplate restTemplate;

    @Autowired
    private OrderServiceConfig config;

    public CustomerServiceClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public AccountDto findAccount(String accountId) {
        AccountDto account = restTemplate.getForObject(config.getCustomerServiceUrl() + "/{id}", AccountDto.class, accountId);
        return account;
    }
}
