package com.namratha.vancouverexplorer.repository;

import com.namratha.vancouverexplorer.model.Place;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryPlaceRepository implements PlaceRepository{

    @Override
    public List<Place> findAll() {

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

        Place lynnCanyonPark = new Place(
                "lynn-canyon-park",
                "Lynn Canyon Park",
                "OUTDOOR",
                "Lynn Valley",
                "Forest trails and a suspension bridge",
                0.0,
                false
        );

        Place vancouverArtGallery = new Place(
                "vancouver-art-gallery",
                "Vancouver Art Gallery",
                "CULTURE",
                "Downtown",
                "Art exhibition in the heart of downtown",
                35.0,
                true
        );

        Place queenElizabethPark = new Place(
                "queen-elizabeth-park",
                "Queen Elizabeth Park",
                "OUTDOOR",
                "Riley Park",
                "Gardens and scenic city views",
                0.0,
                false
        );

        Place scienceWorld = new Place(
                "science-world",
                "Science World",
                "SCIENCE",
                "False Creek",
                "Interactive science exhibits",
                35.0,
                true
        );

        Place grouseMountain = new Place(
                "grouse-mountain",
                "Grouse Mountain",
                "OUTDOOR",
                "Grouse Mountain",
                "Mountain views and seasonal activities",
                85.0,
                false
        );

        return List.of(stanleyPark, granvilleIsland, lynnCanyonPark, vancouverArtGallery, queenElizabethPark, scienceWorld, grouseMountain);
    }

    @Override
    public List<Place> findByMaxCost(double maxCost) {
        return findAll()
                .stream()
                .filter(place -> place.getEstimatedCost() <= maxCost)
                .toList();
    }
}
