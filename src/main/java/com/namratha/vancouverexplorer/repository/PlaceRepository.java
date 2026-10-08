package com.namratha.vancouverexplorer.repository;

import com.namratha.vancouverexplorer.model.Place;

import java.util.List;

public interface PlaceRepository {
    List<Place> findAll();

    //this does not handle external requests and maxCost will always be provided hence double
    List<Place> findByMaxCost(double maxCost);
}
