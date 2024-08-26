package com.atsairport.entity;

import jakarta.persistence.*;

@Entity
@Table(name="airport")
public class Airport
{
    @Id
    private String id;
    @Column(name= "AIRPORT_NAME",nullable = false)
    private String airportName;
    @Column(name="COUNTRY_CODE",nullable = false)
    private String countryCode;
    public Airport() {
    }

    public Airport(String id, String airportName, String countryCode) {
        this.id = id;
        this.airportName = airportName;
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}

