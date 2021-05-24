package com.geekshirt.inventory.controllers;


import com.geekshirt.inventory.service.InventoryService;
import com.geekshirt.inventory.util.TestDataUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(InventoryController.class)
public class InventoryControllerIntHttpTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private InventoryService inventoryService;

    @Test
    public void shouldReturnAllProductsWhenProductsIsCalled() throws Exception {
        given(inventoryService.retrieveAllProducts()).willReturn(TestDataUtils.getMockProducts());

        mvc.perform(get("/product")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)));

        verify(inventoryService).retrieveAllProducts();
    }

    @Test
    public void shouldReturnAllProductsWhenProductsByIdIsCalled() throws Exception {
        given(inventoryService.retrieveProductById(anyLong())).willReturn(TestDataUtils.getMockProduct());

        mvc.perform(get("/product/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.name", is(TestDataUtils.getMockProduct().getName())));

        verify(inventoryService).retrieveProductById(anyLong());
    }

}
