package com.silva.marcos.Spring.Overview.controller;

import com.silva.marcos.Spring.Overview.model.Car;
import com.silva.marcos.Spring.Overview.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseBody
    public Car create(@RequestBody Car car) {
        return this.repository.save(car);
    }

}
