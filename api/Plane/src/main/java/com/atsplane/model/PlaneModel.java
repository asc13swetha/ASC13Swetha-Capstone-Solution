package com.atsplane.model;

public class PlaneModel {
        private String id;
        private String planeMaker;
        private String plModel;
        private int planeCapacity;


        // default constructor
        public PlaneModel() {
        }

    public PlaneModel(String id,String plModel,String planeMaker, int planeCapacity) {
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
