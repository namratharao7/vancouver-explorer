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
}
