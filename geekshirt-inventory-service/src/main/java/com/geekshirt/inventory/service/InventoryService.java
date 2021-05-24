package com.geekshirt.inventory.service;

import com.geekshirt.inventory.entities.Product;
import com.geekshirt.inventory.exceptions.ProductNotFoundException;
import com.geekshirt.inventory.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InventoryService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    public Product retrieveProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.orElseThrow(() -> new ProductNotFoundException(productId.toString()));
    }

    public Product retrieveProductBySku(String sku) {
        Optional<Product> product = productRepository.findBySku(sku);
        return product.orElseThrow(() -> new ProductNotFoundException(sku));
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product updatedProduct) {
        Optional<Product> foundProduct = productRepository.findById(updatedProduct.getId());
        Product currentProduct = foundProduct.orElseThrow(() ->
                            new ProductNotFoundException(updatedProduct.getId().toString()));
        BeanUtils.copyProperties(currentProduct, updatedProduct);
        return productRepository.save(currentProduct);
    }

    public void deleteProduct(Long productId){
        if (!productRepository.existsById(productId)){
            log.error("Product Id: {id} not found. ", productId);
            throw new ProductNotFoundException(productId.toString());
        }

        productRepository.deleteById(productId);
        log.info("Product deleted");
    }
}
