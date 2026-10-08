package com.namratha.vancouverexplorer.graphql;

import com.namratha.vancouverexplorer.model.Place;
import com.namratha.vancouverexplorer.repository.PlaceRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

//this is a resolver for the graphql query places
@Controller
public class PlaceQuery {
    private final PlaceRepository placeRepository;

    //Spring calls this constructor (we don't manually call this anywhere) this is called constructor dependency injection
    public PlaceQuery(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

   //Spring can perform constructor injection automatically because PlaceQuery has a single constructor.
   // Therefore, @Autowired is not needed
    @QueryMapping
    //this handles the API input coming from graphql, which includes null value and needs to be handled hence Double
    public List<Place> places(@Argument Double maxCost) {

        List<Place> result;
        if(maxCost == null) {
            result = placeRepository.findAll();
        } else {
            result = placeRepository.findByMaxCost(maxCost);
        }
        return result;
    }
}
