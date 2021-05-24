package com.geekshirt.customerservice.config;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Getter
@EnableJpaAuditing
@Configuration
public class AccountConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
