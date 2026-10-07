package com.namratha.vancouverexplorer.model;

public class Place {
    private String id;
    private String name;
    private String category;
    private String neighbourhood;
    private String description;
    private double estimatedCost;
    private boolean indoor;

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
