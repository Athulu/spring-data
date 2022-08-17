package com.example.demojpa;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class BikeRepository {
    private final EntityManager entityManager;

    public BikeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Bike bike) {
        entityManager.persist(bike);
    }

    public Optional<Bike> findById(Long id){
        return Optional.ofNullable(entityManager.find(Bike.class, id));
    }

    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
//        Bike bike = entityManager.find(Bike.class, id);
//        if (bike != null)
//            entityManager.remove(bike);
    }

}
