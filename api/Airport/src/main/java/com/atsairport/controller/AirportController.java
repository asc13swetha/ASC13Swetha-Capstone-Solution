package com.atsairport.controller;
import com.atsairport.entity.Airport;
import com.atsairport.model.AirportModel;
import com.atsairport.repository.AirportRepository;
import com.atsairport.service.AirportService;
import com.atsairport.exceptions.PlaneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AirportController {
    private final AirportRepository airportRepository;
    private final AirportService airportService;
    @Autowired
    public AirportController(AirportRepository airportRepository, AirportService airportService)
    {
        this.airportRepository = airportRepository;
        this.airportService = airportService;
    }
    @GetMapping("/plane")
    public List<AirportModel> getAllPlanes()
    {
        return airportService.getAllPlanes();
    }
    @GetMapping("/plane/{plId}")
    public AirportModel getPlaneDetails(@PathVariable(value = "plId") String id){
        try{
            Airport airportDetails = airportRepository.findById(id).get();
            return new AirportModel(airportDetails.getId(), airportDetails.getPlaneModel(), airportDetails.getPlaneMaker(), airportDetails.getPlaneCapacity());
        }
        catch(PlaneNotFoundException planeNotFoundException){
            return null;
        }
    }

    @PostMapping("/plane")
    public String insertPlaneDetails(@RequestBody AirportModel plane) {
        if (plane.getPlaneModel() == null || plane.getPlaneMaker() == null || plane.getPlaneCapacity() <= 0 || plane.getPlaneModel().isEmpty() || plane.getPlaneMaker().isEmpty()) {
            return "Provide The Required Details";
        }
        String planeId = airportService.generateId();
        Airport airportDetails = new Airport(planeId,plane.getPlaneModel(), plane.getPlaneMaker(),plane.getPlaneCapacity());
        airportRepository.save(airportDetails);
        return "Plane Details inserted successfully";
    }
    @DeleteMapping("/plane/{plId}")
    public String deletePlaneDetails(@PathVariable(value = "plId") String id){
        try{
            Airport airportDetailsToBeDeleted = airportRepository.findById(id).get();
            airportRepository.delete(airportDetailsToBeDeleted);
            return "Plane Details deleted successfully";
        }
        catch(PlaneNotFoundException planeNotFoundException){
            return "Plane Details is not available";
        }
    }
    @PutMapping("/plane")
    public String updatePlaneDetails(@RequestBody AirportModel airportModel)
    {
        try{
            Airport airportDetailsToBeUpdated = airportRepository.findById(airportModel.getId()).get();
            if(airportModel.getPlaneModel()!=null&&!airportModel.getPlaneModel().isEmpty()) airportDetailsToBeUpdated.setPlaneModel(airportModel.getPlaneModel());
            if(airportModel.getPlaneMaker()!=null&&!airportModel.getPlaneMaker().isEmpty()) airportDetailsToBeUpdated.setPlaneMaker(airportModel.getPlaneMaker());
            try{
                if(airportModel.getPlaneCapacity()>0){
                    airportDetailsToBeUpdated.setPlaneCapacity(airportModel.getPlaneCapacity());
                }
            }
            catch (InputMismatchException inputMismatchException){
                return "Not provided valid seating capacity";
            }
            airportRepository.save(airportDetailsToBeUpdated);
            return "Plane Details updated successfully";
        }
        catch(PlaneNotFoundException planeNotFoundException){
            return "Plane Details not updated for the provided Plane Id";
        }
        }
}
