package com.geekshirt.shippingservice.controllers;

import com.geekshirt.shippingservice.dto.ShipmentDto;
import com.geekshirt.shippingservice.entities.Shipment;
import com.geekshirt.shippingservice.service.ShipmentService;
import com.geekshirt.shippingservice.util.enums.converter.EntityDtoConverter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @ApiOperation(value = "Retrieve a Shipment by tracking Id", notes = "None")
    @GetMapping(value = "/shipment/trackingId/{trackingId}")
    public ResponseEntity<ShipmentDto> retrieveShipmentByTrackingId(@PathVariable(value = "trackingId") String trackingId) {
        Shipment shipment = shipmentService.retrieveShippingByTrackingId(trackingId);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(shipment), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve list of shipments by status", notes = "None")
    @GetMapping(value = "/shipment/status/{status}")
    public ResponseEntity<List<ShipmentDto>> retrieveShipmentsByStatus(@PathVariable(value = "status") String status) {
        List<Shipment> shipments = shipmentService.retrieveShipmentsByStatus(status);
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(shipments), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve all shipments", notes = "None")
    @GetMapping(value = "/shipment")
    public ResponseEntity<List<ShipmentDto>> retrieveAllShipments() {
        List<Shipment> shipments = shipmentService.retrieveAllShipments();
        return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(shipments), HttpStatus.OK);
    }
}
