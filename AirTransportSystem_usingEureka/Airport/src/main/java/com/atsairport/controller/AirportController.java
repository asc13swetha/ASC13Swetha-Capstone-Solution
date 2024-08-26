package com.atsairport.controller;
import com.atsairport.entity.Airport;
import com.atsairport.exceptions.InvalidCountryCodeException;
import com.atsairport.model.AirportModel;
import com.atsairport.repository.AirportRepository;
import com.atsairport.service.AirportService;
import com.atsairport.exceptions.AirportNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirportController {
    private final AirportRepository airportRepository;
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportRepository airportRepository, AirportService airportService) {
        this.airportRepository = airportRepository;
        this.airportService = airportService;
    }

    @GetMapping("/airport")
    public List<AirportModel> getAllAirport()
    {
        return airportService.getAllAirport();
    }

    @GetMapping("/airport/{id}")
    public AirportModel getAirportDetails(@PathVariable(value = "id") String id) {
        try {
            Airport airportDetails = airportRepository.findById(id).get();
            return new AirportModel(airportDetails.getId(),airportDetails.getAirportName(),airportDetails.getCountryCode());
        } catch (AirportNotFoundException airportNotFoundException) {
            return null;
        }
    }
    @PostMapping("/airport")
    public String insertAirportDetails(@RequestBody AirportModel airportModel)
    {
            if (airportModel.getAirportName() == null || airportModel.getAirportName().isEmpty() || airportModel.getCountryCode() == null|| airportModel.getCountryCode().isEmpty()) {
                return "Provide The Required Details";
            }

        try{
            airportService.validateCountryCode(airportModel.getCountryCode());
        }
        catch (InvalidCountryCodeException invalidCountryCodeException) {
            return invalidCountryCodeException.getMessage();
        }
        String bookingId = airportService.generateId();
        Airport airportDetails = new Airport(bookingId, airportModel.getAirportName(), airportModel.getCountryCode());
        airportRepository.save(airportDetails);
        return "Airport Details inserted successfully";
    }

    @DeleteMapping("/airport/{airportId}")
    public String deleteAirportDetails(@PathVariable(value = "airportId") String id) {
        try {
            Airport airportDetailsToBeDeleted = airportRepository.findById(id).get();
            airportRepository.delete(airportDetailsToBeDeleted);
            return "Airport Details deleted successfully";
        } catch (AirportNotFoundException airportNotFoundException) {
            return "Airport Details is not available";
        }
    }

    @PutMapping("/airport")
    public String updateAirportDetails(@RequestBody AirportModel airportModel) {
        try {
            Airport airportDetailsToBeUpdated = airportRepository.findById(airportModel.getId()).get();
            if (airportModel.getAirportName() != null && !airportModel.getAirportName().isEmpty()) {
                airportDetailsToBeUpdated.setAirportName(airportModel.getAirportName());
            }
            if(airportModel.getCountryCode() != null && airportModel.getCountryCode().isEmpty()){
                airportDetailsToBeUpdated.setCountryCode(airportModel.getCountryCode());
            }
            airportRepository.save(airportDetailsToBeUpdated);
            return "Plane Details updated Successfully";
        } catch (AirportNotFoundException airportNotFoundException) {
            return "Airport Details not updated for the provided Airport Id";
        }
    }
}
