package com.example.demojpa;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;

@SpringBootApplication
public class DemoJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoJpaApplication.class, args);
        NewBikeDto bike1 = new NewBikeDto(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        BikeService bikeService = context.getBean(BikeService.class);

        bikeService.add(bike1);
        double payment = bikeService.rentForHour(1L, 5, "ABC123");
        System.out.println("Należność do zapłaty: " + payment);
        bikeService.returnBike(1L);

    }

}
