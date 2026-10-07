package com.namratha.vancouverexplorer.repository;

import com.namratha.vancouverexplorer.model.Place;

import java.util.List;

public interface PlaceRepository {
    List<Place> findAll();
}
