package com.geekshirt.inventory.util;

import com.geekshirt.inventory.entities.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDataUtils {

    public static List<Product> getMockProducts(){
        List<Product> products = new ArrayList<>();

        Product product01 = Product.builder().id(1L).name("DBZ Vegeta Shirt")
                .description("Dragon Ball t-shirt with vegeta stamping")
                .size("L").color("WHITE").image("pictures/dbz/vegeta_white.png")
                .sku("7890123432134").upc("999818727312").unitPrice(19.99)
                .unitsInStock(200)
                .createdDate(new Date()).build();

        Product product02 = Product.builder().id(2L).name("DBZ Goku Shirt")
                .description("Dragon Ball t-shirt with Goku stamping")
                .size("M").color("WHITE").image("pictures/dbz/goku_white.png")
                .sku("7890123432154").upc("999818727352").unitPrice(19.99)
                .unitsInStock(250)
                .createdDate(new Date()).build();

        Product product03 = Product.builder().id(3L).name("DBZ Gotenks Shirt")
                .description("Dragon Ball t-shirt with Gotenks stamping")
                .size("XL").color("WHITE").image("pictures/dbz/vegeta_white.png")
                .sku("7890123432194").upc("999818727392").unitPrice(19.99)
                .unitsInStock(300)
                .createdDate(new Date()).build();

        products.add(product01);
        products.add(product02);
        products.add(product03);

        return products;
    }

    public static Product getMockProduct(){
        return Product.builder().id(2L).name("DBZ Gotenks Shirt")
                .description("Dragon Ball t-shirt with Gotenks stamping")
                .size("XL").color("WHITE").image("pictures/dbz/vegeta_white.png")
                .sku("7890123432194").upc("999818727392").unitPrice(19.99)
                .unitsInStock(300)
                .createdDate(new Date()).build();
    }
}
