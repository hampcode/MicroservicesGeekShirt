package com.geekshirt.inventory.controllers;

import com.geekshirt.inventory.dto.LineItem;
import com.geekshirt.inventory.entities.Product;
import com.geekshirt.inventory.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Slf4j
@Api
@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @ApiOperation(value = "Retrieve all products existed in the catalog", notes = "None")
    @GetMapping(value = "/product")
    public ResponseEntity<List<Product>> retrieveAllProducts(){
        return new ResponseEntity<>(inventoryService.retrieveAllProducts(), HttpStatus.OK);
    }

    @ApiOperation(value = "Save a new product in the inventory", notes = "A new product has to be populated")
    @PostMapping(value = "/product")
    public ResponseEntity<Void> saveProduct(@RequestBody Product product){
        Product productObj = inventoryService.saveProduct(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(productObj.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Updates Inventory based on Line Items", notes = "Updates Inventory based on Line Items")
    @PostMapping(value = "/inventory")
    public ResponseEntity<String> updateInventory(@RequestBody List<LineItem> items){
        log.info("Updating Inventory, following products: {}", items);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>("Line Items Updated.", headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Updates a product in the inventory", notes = "A new product has to be populated")
    @PutMapping(value = "/product")
    public ResponseEntity updateProduct(@RequestBody Product updatedProduct){
        return new ResponseEntity(inventoryService.updateProduct(updatedProduct), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieves a product from the catalog by product Id", notes = "The Product Id must be appended as part of the url")
    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) throws Exception {
        return new ResponseEntity<>(inventoryService.retrieveProductById(productId), HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes a product from the catalog by product Id", notes = "The Product Id must be appended as part of the url")
    @DeleteMapping(value = "/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        inventoryService.deleteProduct(productId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Retrieves a product from the catalog by product sku", notes = "The Product sku must be appended as part of the url")
    @GetMapping(value = "/product/sku/{sku}")
    public ResponseEntity<Product> retrieveProductBySku(@PathVariable String sku) throws Exception {
        return new ResponseEntity<>(inventoryService.retrieveProductBySku(sku), HttpStatus.OK);
    }
}
