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

    @Test
    void getPlacesWithOnlyCategoryConstraintFiltersPlaces() {
        //Arrange
        PlaceRepository mockPlaceRepository = Mockito.mock(PlaceRepository.class);
        PlaceService placeService = new PlaceService(mockPlaceRepository);

        Place stanleyPark = new Place(
                "stanley-park",
                "Stanley Park",
                "OUTDOOR",
                "West End",
                "A large urban park with lots of  greenery, walking and biking paths and some eateries along the way",
                0.0,
                false
        );
        Place granvilleIsland = new Place(
                "granville-island",
                "Granville Island",
                "CULTURE",
                "Fairview",
                "A waterfront district known for its public market, food and arts",
                20.0,
                false
        );

        List<Place> expectedPlaces = List.of(stanleyPark, granvilleIsland);
        Mockito.when(mockPlaceRepository.findAll()).thenReturn(expectedPlaces);

        //Act
        //call the service with maxCost=null and category="Outdoor" and capture its return value
        List<Place> actualPlaces = placeService.getPlaces(null,"Outdoor");

        //Assert
        Mockito.verify(mockPlaceRepository).findAll();
        assertEquals(1, actualPlaces.size());
        assertEquals("Stanley Park", actualPlaces.get(0).getName());
    }

    @Test
    void getPlacesWithBothMaxCostAndCategoryFiltersPlaces() {
        //Arrange
        PlaceRepository mockPlaceRepository = Mockito.mock(PlaceRepository.class);
        PlaceService placeService = new PlaceService(mockPlaceRepository);

        Place stanleyPark = new Place(
                "stanley-park",
                "Stanley Park",
                "OUTDOOR",
                "West End",
                "A large urban park with lots of  greenery, walking and biking paths and some eateries along the way",
                0.0,
                false
        );
        Place granvilleIsland = new Place(
                "granville-island",
                "Granville Island",
                "CULTURE",
                "Fairview",
                "A waterfront district known for its public market, food and arts",
                20.0,
                false
        );

        Place vancouverArtMuseum = new Place(
                "art-museum",
                "Vancouver Art Museum",
                "CULTURE",
                "Downtown",
                "A beautiful indoor museum with curated heritage and art pieces",
                10.0,
                true
        );

        Place whistler = new Place(
                "whistler",
                "Whistler Town",
                "OUTDOOR",
                "Whistler",
                "A ski town created in the 1060's with the hope and dream of hosting the winter Olympics in the future, which that town did in 2010.",
                30.0,
                false
        );

        List<Place> expectedPlaces = List.of(stanleyPark, granvilleIsland, vancouverArtMuseum, whistler);
        Mockito.when(mockPlaceRepository.findAll()).thenReturn(expectedPlaces);

        //Act
        List<Place> actualPlaces = placeService.getPlaces(15.0, "Outdoor");

        //Assert
        Mockito.verify(mockPlaceRepository).findAll();
        assertEquals(1, actualPlaces.size());
        assertEquals("Stanley Park", actualPlaces.get(0).getName());
    }
}
