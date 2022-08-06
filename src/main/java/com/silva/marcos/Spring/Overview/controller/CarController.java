package com.silva.marcos.Spring.Overview.controller;

import com.silva.marcos.Spring.Overview.model.Car;
import com.silva.marcos.Spring.Overview.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Car> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> findAll(@PathVariable Integer id) {
        return this.repository.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Car create(@RequestBody Car car) {
        return this.repository.save(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeById(@PathVariable Integer id) {
        this.repository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateById(@PathVariable Integer id, @RequestBody Car car) {
        this.repository.findById(id).map(record -> {
            record.setName(car.getName());
            record.setColor(car.getColor());
            record.setYear(car.getYear());

            Car carUpdated = this.repository.save(record);
            return carUpdated;
        });
    }


}
