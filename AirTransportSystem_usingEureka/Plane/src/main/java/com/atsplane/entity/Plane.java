package com.atsplane.entity;

import jakarta.persistence.*;

@Entity
@Table(name="plane")
public class Plane
{
    @Id
    private String id;
    @Column(name= "PLANE_MAKER",nullable = false)
    private String planeMaker;
    @Column(name= "MODEL",nullable = false)
    private String plModel;
    @Column(name= "CAPACITY",nullable = false)
    private int planeCapacity;


    public Plane() {
    }

    public Plane(String id, String plModel, String planeMaker, int planeCapacity) {
        this.id = id;
        this.plModel = plModel;
        this.planeMaker = planeMaker;
        this.planeCapacity = planeCapacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaneModel() {
        return plModel;
    }

    public void setPlaneModel(String plModel)
    {
        this.plModel = plModel;
    }

    public String getPlaneMaker() {
        return planeMaker;
    }

    public void setPlaneMaker(String planeMaker) {
        this.planeMaker = planeMaker;
    }
    public int getPlaneCapacity() {
        return planeCapacity;
    }

    public void setPlaneCapacity(int planeCapacity)
    {
        this.planeCapacity = planeCapacity;
    }
}

