package com.example.StorePlusApi.data;

import com.example.StorePlusApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findById(long id);
}
