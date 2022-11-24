package com.uncledavecode.entitiesdtos.controllers;

import com.uncledavecode.entitiesdtos.model.dtos.CityDto;
import com.uncledavecode.entitiesdtos.model.entities.City;
import com.uncledavecode.entitiesdtos.repositories.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;

@RestController
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/all")
    public List<City> getAllCitiesEntities(){
        long start = System.currentTimeMillis();
        var cities = this.cityRepository.findAllCitiesEntities();

        this.logDuration("getAllCitiesEntities()", Duration.ofMillis(System.currentTimeMillis()-start), cities.size());

        return cities;
    }

    @GetMapping("/dtos")
    public List<CityDto> getAllCitiesDtos(){
        long start = System.currentTimeMillis();
        var cities = this.cityRepository.findAllCitiesDtos();

        this.logDuration("getAllCitiesDtos()", Duration.ofMillis(System.currentTimeMillis()-start), cities.size());

        return cities;
    }

    private void logDuration(String serviceName, Duration duration, int size){
        System.out.println("Service: "+serviceName + " took " +duration.toMillis()+ " ms to return " + size + " records");
    }
}
