package com.namratha.vancouverexplorer.repository;

import com.namratha.vancouverexplorer.model.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InMemoryPlaceRepositoryTest {

    private InMemoryPlaceRepository inMemoryPlaceRepository;
    @BeforeEach
    void setUp() {
        inMemoryPlaceRepository = new InMemoryPlaceRepository();
    }

    @Test
    void findByMaxCostReturnsPlacesWithinBudget() {
        //Arrange
        //Act
        List< Place> result = inMemoryPlaceRepository.findByMaxCost(15);

        //Assert
        assertEquals(1, result.size());
        assertEquals("Stanley Park", result.get(0).getName());
    }

    @Test
    void findByMaxCostIncludesPlacesAtExactBudget() {
        //Arrange
        //Act
        List<Place> result = inMemoryPlaceRepository.findByMaxCost(20);

        //Assert
        assertEquals(2, result.size());
    }

    @Test
    void findByMaxCostReturnsEmptyListWhenNoPlacesMatch() {
        //Arrange
        //Act
        List<Place> result = inMemoryPlaceRepository.findByMaxCost(-1);

        //Assert
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }
}
