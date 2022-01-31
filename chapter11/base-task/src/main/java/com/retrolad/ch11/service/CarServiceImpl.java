package com.retrolad.ch11.service;

import com.google.common.collect.Lists;
import com.retrolad.ch11.entities.Car;
import com.retrolad.ch11.repos.CarRepository;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Repository
@Transactional
public class CarServiceImpl implements CarService {

    public boolean done;
    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    @Scheduled(fixedDelay = 10000)
    public void updateCarAgeJob() {
        List<Car> cars = findAll();

        DateTime currentTime = DateTime.now();
        logger.info("Car age update job started");

        cars.forEach(car -> {
            int age = Years.yearsBetween(car.getManufactureDate(), currentTime).getYears();

            car.setAge(age);
            save(car);

            logger.info("Car age update job completed successfully");
            done = true;
        });
    }

    @Override
    public boolean isDone() {
        return done;
    }
}
