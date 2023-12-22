package com.pluralsight.NorthwindTradersSpringBoot.configs;

import com.pluralsight.NorthwindTradersSpringBoot.daos.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.daos.SimpleProductDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ProductDAO productDAO(){
        return new SimpleProductDAO();
    }
}
