package com.atsairport.model;
public class AirportModel
{
    private String id;
    private String airportName;
    private String countryCode;



        // default constructor
        public AirportModel() {
        }

    public AirportModel(String id, String airportName, String countryCode)
    {
        this.id = id;
        this.airportName = airportName;
        this.countryCode=countryCode;
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
