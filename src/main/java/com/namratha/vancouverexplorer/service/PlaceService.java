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
}
