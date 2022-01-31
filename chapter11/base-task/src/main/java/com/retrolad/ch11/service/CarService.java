package com.retrolad.ch11.service;

import com.retrolad.ch11.entities.Car;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {

    List<Car> findAll();
    Car save(Car car);
    void updateCarAgeJob();
    boolean isDone();
}
