package com.example.StorePlusApi.data;
import com.example.StorePlusApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    public List products = new ArrayList<Product>();
    private ProductRepository productRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        products.addAll(Arrays.asList(
                new Product("produit 1",20,"assets/image.jpeg","description de ce produit"),
                new Product("produit 2",30,"assets/image.jpeg","description de ce produit"),
                new Product("produit 3",40,"assets/image.jpeg","description de ce produit"),
                new Product("produit 4",50,"assets/image.jpeg","description de ce produit")
        ));
        this.productRepository.saveAll(products);
    }
}
