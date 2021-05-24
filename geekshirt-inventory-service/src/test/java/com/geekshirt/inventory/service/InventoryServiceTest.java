package com.geekshirt.inventory.service;

import com.geekshirt.inventory.entities.Product;
import com.geekshirt.inventory.exceptions.ProductNotFoundException;
import com.geekshirt.inventory.repositories.ProductRepository;
import com.geekshirt.inventory.util.TestDataUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @Test
    public void shouldReturnAllProductsWhenRetrieveAllProductsIsCalled(){
        when(productRepository.findAll()).thenReturn(TestDataUtils.getMockProducts());
        assertEquals(true, inventoryService.retrieveAllProducts() != null);
        verify(productRepository).findAll();
    }

    @Test
    public void shouldReturnProductByIdWhenRetrieveProductByIdIsCalled(){
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(TestDataUtils.getMockProduct()));
        assertEquals(true, inventoryService.retrieveProductById(1L) != null);
        verify(productRepository).findById(anyLong());
    }

    @Test(expected = ProductNotFoundException.class)
    public void shouldThrowProductNotFoundExceptionWhenRetrieveProductByIdNotFound(){
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertEquals(false, inventoryService.retrieveProductById(1L) != null);
        verify(productRepository).findById(anyLong());
    }

    @Test(expected = ProductNotFoundException.class)
    public void shouldThrowProductNotFoundExceptionWhenDeleteDoesNotFindId(){
        when(productRepository.existsById(anyLong())).thenReturn(false);

        inventoryService.deleteProduct(1L);
        verify(productRepository, never()).deleteById(anyLong());
    }

    @Test
    public void shouldReturnProductWhenUpdates() {
        Product sampleProduct = TestDataUtils.getMockProduct();
        sampleProduct.setUnitsInStock(150);

        when(productRepository.save(any())).thenReturn(sampleProduct);
        when(productRepository.findById(any())).thenReturn(Optional.of(TestDataUtils.getMockProduct()));

        inventoryService.updateProduct(sampleProduct);
        verify(productRepository).save(any());
    }

    @Test
    public void shouldReturnProductWhenSaveProduct() {
        when(productRepository.save(any())).thenReturn(TestDataUtils.getMockProduct());
        inventoryService.saveProduct(TestDataUtils.getMockProduct());
        verify(productRepository).save(any());
    }

    @Test
    public void shouldDeleteProductWhenDeleteFindsProduct(){
        when(productRepository.existsById(anyLong())).thenReturn(true);

        inventoryService.deleteProduct(1L);
        verify(productRepository).deleteById(anyLong());
    }
}
