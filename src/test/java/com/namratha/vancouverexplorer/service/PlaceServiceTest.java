package com.namratha.vancouverexplorer.service;

import com.namratha.vancouverexplorer.model.Place;
import com.namratha.vancouverexplorer.repository.PlaceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceServiceTest {

    @Test
    void getPlacesWithoutBudgetReturnsAllPlaces() {
        //Arrange
        PlaceRepository mockPlaceRespository = Mockito.mock(PlaceRepository.class);
        PlaceService placeService = new PlaceService(mockPlaceRespository);

        //controlling what the mocked method returns - stubbing
        List<Place> expectedPlaces = List.of();
        Mockito.when(mockPlaceRespository.findAll()).thenReturn(expectedPlaces);

        //Act
        //capture the returned value
        List<Place> actualPlaces = placeService.getPlaces(null);

        //Assert
        assertEquals(expectedPlaces, actualPlaces);
        Mockito.verify(mockPlaceRespository).findAll();
    }

    @Test
    void getPlacesWithBudgetFiltersPlaces() {
        //Arrange
        //create a mock repository
        PlaceRepository mockPlaceRepository = Mockito.mock(PlaceRepository.class);
        //inject it into a placeService
        PlaceService placeService = new PlaceService(mockPlaceRepository);

        //Act
        //configure the mock
        List<Place> expectedPlaces = List.of();
        Mockito.when(mockPlaceRepository.findByMaxCost(15.0)).thenReturn(expectedPlaces);

        //Assert
        //call the service with a budget of 15 and capture its return value
        List<Place> actualPlaces = placeService.getPlaces(15.0);

        assertEquals(expectedPlaces, actualPlaces);
        Mockito.verify(mockPlaceRepository).findByMaxCost(15.0);
        Mockito.verify(mockPlaceRepository, Mockito.never()).findAll();
    }
}
