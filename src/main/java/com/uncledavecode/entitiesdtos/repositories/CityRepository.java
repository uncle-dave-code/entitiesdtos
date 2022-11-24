package com.uncledavecode.entitiesdtos.repositories;

import com.uncledavecode.entitiesdtos.model.dtos.CityDto;
import com.uncledavecode.entitiesdtos.model.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query("""
            SELECT c FROM City c
            """)
    List<City> findAllCitiesEntities();


    @Query("""
            SELECT new com.uncledavecode.entitiesdtos.model.dtos.CityDto(c.id, c.name, c.country) FROM City c
            """)
    List<CityDto> findAllCitiesDtos();
}
