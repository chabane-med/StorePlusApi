package com.example.StorePlusApi.data;

import com.example.StorePlusApi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    private Product productOne, productTwo;

    @BeforeEach
    public void setup(){
        productOne = new Product("p1",20,"/image","description");
        productTwo = new Product("p2",30,"/image","description");
    }
    @Test
    public void injectedRepositoryIsNotNull(){
        assertThat(productRepository).isNotNull();

    }

    @Test
    public void testSaveProduct(){
        Product savedProduct = productRepository.save(productOne);
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isGreaterThan(0);
        assertThat(savedProduct.getName()).isEqualTo("p1");
        assertThat(savedProduct.getImage()).isEqualTo("/image");
        assertThat(savedProduct.getPrice()).isEqualTo(20);
        assertThat(savedProduct.getDescription()).isEqualTo("description");

    }

    @Test
    public void FindAllProduct(){
        productRepository.save(productOne);
        productRepository.save(productTwo);
        List<Product> productList = productRepository.findAll();
        assertThat(productList).isNotNull();
        assertThat(productList.size()).isEqualTo(2);
    }

    @Test
    public void FindProductById_If_Null(){
        Product product = productRepository.findById(1);
        assertThat(product).isNull();
    }

    @Test
    public void FindProductById(){
        productRepository.save(productOne);
        Product product = productRepository.findById(productOne.getId());
        assertThat(product).isNotNull();
    }
}
