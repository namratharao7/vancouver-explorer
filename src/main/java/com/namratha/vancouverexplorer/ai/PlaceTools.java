package com.namratha.vancouverexplorer.ai;

import com.namratha.vancouverexplorer.model.Place;
import com.namratha.vancouverexplorer.service.PlaceService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaceTools {
    private final PlaceService placeService;

    public PlaceTools(PlaceService placeService) {
        this.placeService = placeService;
    }
    //exposing the tools to gemini api for use

    //The description matters because Gemini uses it to understand when the tool is useful.
    @Tool("Find places to visit in Vancouver, optionally filtering by maximum budget in CAD and place category.")
    public List<Place> searchPlaces(
            @P(value = "Maximum estimated cost per place in Canadian dollars (CAD).", required = false)
            Double maxCost,
            @P(value = "Place category, such as Outdoor or Culture. Matches are case-insensitive.", required = false)
            String category
    ) {
        return placeService.getPlaces(maxCost, category);
    }

    @Tool("Find places in the specified neighbourhood to visit in Vancouver.")
    public List<Place> findPlacesByNeighbourhood(
            @P(value = "Place Neighbourhood, such as Downtown or Whistler. Matches are case-insensitive.")
            String neighbourhood
    ) {
        return placeService.getPlacesByNeighbourhood(neighbourhood);
    }
}
