package com.namratha.vancouverexplorer.repository;

import com.namratha.vancouverexplorer.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Place — The entity this repository manages.
//String — The datatype of the entity's primary key (id).

//By extending JpaRepository, Spring Data provides implementations of common database operations,
// including findAll(), findById(), and save(), without us writing SQL
public interface JpaPlaceRepository extends JpaRepository<Place, String> {

    List<Place> findByEstimatedCostIsLessThanEqual(Double maxCost);
}
