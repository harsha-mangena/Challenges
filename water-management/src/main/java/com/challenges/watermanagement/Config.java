package com.challenges.watermanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challenges.watermanagement.Entity.Apartment;

@Configuration
public class Config {
    
    @Bean
    public Apartment getApartment(){
        return new Apartment();
    }
}
