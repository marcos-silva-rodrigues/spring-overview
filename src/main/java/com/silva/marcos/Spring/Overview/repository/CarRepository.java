package com.silva.marcos.Spring.Overview.repository;

import com.silva.marcos.Spring.Overview.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

//    String findByName(String name);
}
