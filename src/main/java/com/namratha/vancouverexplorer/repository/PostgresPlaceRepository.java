package com.namratha.vancouverexplorer.repository;

import com.namratha.vancouverexplorer.model.Place;
import org.springframework.stereotype.Repository;

import java.util.List;

//adapter that connect the PlaceRepository and JpaPlaceRepository interfaces
@Repository
public class PostgresPlaceRepository implements PlaceRepository {

    private final JpaPlaceRepository jpaPlaceRepository;

    public PostgresPlaceRepository(JpaPlaceRepository jpaPlaceRepository) {
        this.jpaPlaceRepository = jpaPlaceRepository;
    }

    @Override
    public List<Place> findAll() {
        //simply delegate to Spring Data JPA
        return jpaPlaceRepository.findAll();
    }

    @Override
    public List<Place> findByMaxCost(double maxCost) {
        return jpaPlaceRepository.findByEstimatedCostIsLessThanEqual(maxCost);
    }
}
