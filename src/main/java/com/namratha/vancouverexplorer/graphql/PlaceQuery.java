package com.namratha.vancouverexplorer.graphql;

import com.namratha.vancouverexplorer.model.Place;
import com.namratha.vancouverexplorer.service.PlaceService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

//this is a resolver for the graphql query places(maxCost)
@Controller
public class PlaceQuery {
    private final PlaceService placeService;

    //Spring calls this constructor (we don't manually call this anywhere) this is
    // called constructor dependency injection

    //Spring can perform constructor injection automatically because PlaceQuery has a single constructor.
    // Therefore, @Autowired is not needed
    public PlaceQuery(PlaceService placeService) {
        this.placeService = placeService;
    }
    @QueryMapping
    public List<Place> places(@Argument Double maxCost) {
        return placeService.getPlaces(maxCost);
    }
}
