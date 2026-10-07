package com.namratha.vancouverexplorer.graphql;

import com.namratha.vancouverexplorer.model.Place;
import com.namratha.vancouverexplorer.repository.PlaceRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlaceQuery {
    private final PlaceRepository placeRepository;

    //Spring calls this constructor (we don't manually call this anywhere) this is called constructor dependency injection
    public PlaceQuery(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

//    Spring can perform constructor injection automatically because PlaceQuery has a single constructor. @Autowired is not needed

    @QueryMapping
    public List<Place> places() {

        return placeRepository.findAll();
    }
}
