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
        return List.of(stanleyPark, granvilleIsland);
    }

    @Override
    public List<Place> findByMaxCost(double maxCost) {
        return findAll()
                .stream()
                .filter(place -> place.getEstimatedCost() <= maxCost)
                .toList();
    }
}
