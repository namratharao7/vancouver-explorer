package com.namratha.vancouverexplorer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "places")
public class Place {
    @Id
    private String id;
    private String name;
    private String category;
    private String neighbourhood;
    private String description;
    //Spring Boot's default Hibernate naming strategy would typically map estimatedCost to estimated_cost automatically.
    // We're adding the annotation to make that relationship explicit
    @Column(name = "estimated_cost")
    private double estimatedCost;
    private boolean indoor;

    protected Place() {
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getDescription() {
        return description;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public String getId() {
        return id;
    }

    public Place(String id, String name, String category, String neighbourhood, String description, double estimatedCost, boolean indoor) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.neighbourhood = neighbourhood;
        this.description = description;
        this.estimatedCost = estimatedCost;
        this.indoor = indoor;
    }

}
