package com.geekshirt.inventory.controllers;


import com.geekshirt.inventory.entities.Product;
import com.geekshirt.inventory.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldReturnProductBySkuWhenGetProductBySkuIsCalled(){
        Product productItem = Product.builder().name("DBZ Gotenks Shirt")
                .description("Dragon Ball t-shirt with Gotenks stamping")
                .size("XL").color("WHITE").image("pictures/dbz/vegeta_white.png")
                .sku("7890123432194").upc("999818727392").unitPrice(19.99)
                .unitsInStock(300)
                .createdDate(new Date()).build();

        entityManager.persistAndFlush(productItem);

        Optional<Product> product = productRepository.findBySku("7890123432194");
        assertEquals(true, product.isPresent());
        assertEquals(productItem.getSku(), product.get().getSku());
    }

    @Test
    public void shouldReturnAllProductsWhenProductsIsCalled(){
        Product firstProduct = Product.builder().name("DBZ Gotenks Shirt")
                .description("Dragon Ball t-shirt with Gotenks stamping")
                .size("XL").color("WHITE").image("pictures/dbz/vegeta_white.png")
                .sku("7890123432194").upc("999818727392").unitPrice(19.99)
                .unitsInStock(300)
                .createdDate(new Date()).build();


        Product secondProduct = Product.builder().name("DBZ Bulma Shirt")
                .description("Dragon Ball t-shirt with Bulma stamping")
                .size("S").color("PINK").image("pictures/dbz/bulma_shirt_pink.png")
                .sku("7890123432134").upc("999818727311").unitPrice(19.99)
                .unitsInStock(10)
                .createdDate(new Date()).build();

        entityManager.persistAndFlush(firstProduct);
        entityManager.persistAndFlush(secondProduct);

        List<Product> products = productRepository.findAll();
        assertEquals(true, !products.isEmpty());
        assertEquals(3, products.size());
    }
}
