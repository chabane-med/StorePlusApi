package com.example.StorePlusApi.controller;

import com.example.StorePlusApi.data.ProductRepository;
import com.example.StorePlusApi.model.Product;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    private Product productOne, productTwo;
    @BeforeEach
    public void setup(){
        productOne = new Product("p1",20,"/image","description");
        productTwo = new Product("p2",30,"/image","description");
    }
    @Test
    void findAllProduct() throws Exception {
        List<Product> products = new ArrayList<Product>();
        products.addAll(Arrays.asList(productOne,productTwo));
        Mockito.when(productRepository.findAll()).thenReturn(products);
        mockMvc.perform(get("/products")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("p1")));
    }
}
