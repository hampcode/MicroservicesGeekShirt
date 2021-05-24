package com.geekshirt.shippingservice.util.enums.converter;

import com.geekshirt.shippingservice.dto.AddressDto;
import com.geekshirt.shippingservice.dto.ShipmentDto;
import com.geekshirt.shippingservice.entities.Address;
import com.geekshirt.shippingservice.entities.Shipment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ShipmentDto convertEntityToDto(Shipment shipment) {
        return modelMapper.map(shipment, ShipmentDto.class);
    }

    public List<ShipmentDto> convertEntityToDto(List<Shipment> shipments) {
        return shipments.stream()
                .map(shipment -> modelMapper.map(shipment, ShipmentDto.class))
                .collect(Collectors.toList());
    }

    public Address convertDtoToEntity(AddressDto address) {
        return modelMapper.map(address, Address.class);
    }

    public AddressDto convertToDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }
}
