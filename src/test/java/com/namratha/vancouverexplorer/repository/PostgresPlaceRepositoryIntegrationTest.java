package com.namratha.vancouverexplorer.repository;

import com.namratha.vancouverexplorer.model.Place;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PostgresPlaceRepositoryIntegrationTest {

    @Autowired
    private PlaceRepository placeRepository;

    @Test
    void shouldRetrieveAllPlacesFromDB() {
        List<Place> places = placeRepository.findAll();

        assertEquals(12, places.size());

    }

    @Test
    void shouldRetriecePlacesWithinBudget() {
        List<Place> places = placeRepository.findByMaxCost(20.0);

        assertEquals(7, places.size());
        assertTrue(places.stream().allMatch(place -> place.getEstimatedCost() <= 20.0));
    }
}
