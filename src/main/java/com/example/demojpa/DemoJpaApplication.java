package com.example.demojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoJpaApplication.class, args);
        BikeDto bike1 = new BikeDto(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        BikeDto bike2 = new BikeDto(2L, "Rower2", "AAA12345", 10, 200);
        BikeDto bike3 = new BikeDto(3L, "Rower3", "BBB12345", 20, 300);
        BikeDto bike4 = new BikeDto(4L, "Rower4", "CCC12345", 30, 400);
        BikeService bikeService = context.getBean(BikeService.class);

        bikeService.add(bike1);
        bikeService.add(bike2);
        bikeService.add(bike3);
        bikeService.add(bike4);

        double payment = bikeService.rentForHour("AAA12345", 5, "ABC123");
        System.out.println("Należność do zapłaty: " + payment);

        int borrowedBikes = bikeService.countBorrowedBikes();
        System.out.println("Wypożyczono " + borrowedBikes + " rowerów");

        System.out.println("Dostępne rowery (cena rosnąco): ");
        bikeService.findAllAvailableBikes().forEach(System.out::println);

        bikeService.returnBike("CCC12345");

    }

}
