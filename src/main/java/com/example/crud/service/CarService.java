package com.example.crud.service;

import com.example.crud.entity.Car;
import com.example.crud.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car) {
        carRepository.save(car);
        return car;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(Integer id) {
        Optional<Car> car = carRepository.findById(id);

        if (car.isPresent()) {
            return car;

        } else {
            return Optional.empty();
        }
    }

    public Optional<Car> updateCarType(Integer id, String type) {
        Optional<Car> car = carRepository.findById(id);

        if(car.isPresent()) {
            car.get().setType(type);
            carRepository.save(car.get());

        } else {
            return Optional.empty();
        }
        return car;
    }

    public Optional<Car> deleteById(Integer id) {
        Optional<Car> car = carRepository.findById(id);

        if (car.isPresent()) {
            carRepository.deleteById(id);
            return car;

        } else {
            return Optional.empty();
        }
    }

    public void deleteAll() {
        carRepository.deleteAll();
    }
}
