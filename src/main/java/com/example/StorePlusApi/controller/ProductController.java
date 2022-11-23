package com.example.StorePlusApi.controller;

import com.example.StorePlusApi.data.ProductRepository;
import com.example.StorePlusApi.model.Product;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    @CrossOrigin(origins="http://localhost:4200")
    public ResponseEntity<?> findAll(){
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @RequestMapping("product/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id){
        Product product = productRepository.findById(id);
        if(product == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(product);
    }


}
