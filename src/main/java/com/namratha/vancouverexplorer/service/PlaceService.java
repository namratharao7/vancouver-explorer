package com.namratha.vancouverexplorer.service;

import com.namratha.vancouverexplorer.model.Place;
import com.namratha.vancouverexplorer.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    //since this is the only constructor, we don't need @Autowired for dependency injection
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getPlaces(Double maxCost) {
        List<Place> result;
        if(maxCost == null) {
            result = placeRepository.findAll();
        } else {
            result = placeRepository.findByMaxCost(maxCost);
        }
        return result;
    }

    public List<Place> getPlaces(Double maxCost, String category) {
        List<Place> result = placeRepository.findAll();

        //if there are maxCost restrictions then lets filter out all places over that maxCost
        if(maxCost != null) {
            //use Streams to filter out maxCost
           result =  result.stream().filter(place -> place.getEstimatedCost() <= maxCost).toList();
        }
        //if there are category restrictions then lets filter out all places that don't belong to that category
        if(category != null && !category.isBlank()) {
            result = result.stream().filter(place ->  place.getCategory().equalsIgnoreCase(category)).toList();
        }
        return result;
    }
}
