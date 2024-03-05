package com.example.crud.controller;

import com.example.crud.entity.Car;
import com.example.crud.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/car")
    public ResponseEntity<Car> addCar(@RequestBody Car newCar) {
        carService.addCar(newCar);
        return ResponseEntity.ok().body(newCar);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> findById(@PathVariable Integer id) {
        Optional<Car> car = carService.findById(id);

        if(car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(car.get());
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> findAll() {
        List<Car> cars = carService.findAll();

        if(cars.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cars);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Car> updateCarType(@PathVariable Integer id, @RequestParam String type) {
        Optional<Car> car = carService.updateCarType(id, type);

        if(car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(car.get());
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Car> deleteById(@PathVariable Integer id) {
        Optional<Car> car = carService.deleteById(id);

        if(car.isEmpty()) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.ok().body(car.get());
    }

    @DeleteMapping("/cars")
    public ResponseEntity<Car> deleteAll() {
        carService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
