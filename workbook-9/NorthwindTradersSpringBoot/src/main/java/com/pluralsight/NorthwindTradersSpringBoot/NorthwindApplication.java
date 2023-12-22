package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NorthwindApplication implements CommandLineRunner {

    private final ProductService productService;

    public NorthwindApplication(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        productService.getAll().forEach(product -> System.out.println(product.toString()));
    }
}
