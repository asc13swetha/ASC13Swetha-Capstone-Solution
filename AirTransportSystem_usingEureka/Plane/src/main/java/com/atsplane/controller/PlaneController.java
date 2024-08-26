package com.atsplane.controller;
import com.atsplane.entity.Plane;
import com.atsplane.model.PlaneModel;
import com.atsplane.repository.PlaneRepository;
import com.atsplane.service.PlaneService;
import com.atsplane.exceptions.PlaneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaneController {
    private final PlaneRepository planeRepository ;
    private final PlaneService planeService;
    @Autowired
    public PlaneController(PlaneRepository planeRepository,PlaneService planeService)
    {
        this.planeRepository=planeRepository;
        this.planeService=planeService;
    }
    @GetMapping("/plane")
    public List<PlaneModel> getAllPlanes()
    {
        return planeService.getAllPlanes();
    }
    @GetMapping("/plane/{plId}")
    public PlaneModel getPlaneDetails(@PathVariable(value = "plId") String id){
        try{
            Plane planeDetails=planeRepository.findById(id).get();
            return new PlaneModel(planeDetails.getId(),planeDetails.getPlaneModel(),planeDetails.getPlaneMaker(),planeDetails.getPlaneCapacity());
        }
        catch(PlaneNotFoundException planeNotFoundException){
            return null;
        }
    }

    @PostMapping("/plane")
    public String insertPlaneDetails(@RequestBody PlaneModel plane) {
        if (plane.getPlaneModel() == null || plane.getPlaneMaker() == null || plane.getPlaneCapacity() <= 0 || plane.getPlaneModel().isEmpty() || plane.getPlaneMaker().isEmpty()) {
            return "Provide The Required Details";
        }
        String planeId = planeService.generateId();
        Plane planeDetails = new Plane(planeId,plane.getPlaneModel(), plane.getPlaneMaker(),plane.getPlaneCapacity());
        planeRepository.save(planeDetails);
        return "Plane Details inserted successfully";
    }
    @DeleteMapping("/plane/{plId}")
    public String deletePlaneDetails(@PathVariable(value = "plId") String id){
        try{
            Plane planeDetailsToBeDeleted=planeRepository.findById(id).get();
            planeRepository.delete(planeDetailsToBeDeleted);
            return "Plane Details deleted successfully";
        }
        catch(PlaneNotFoundException planeNotFoundException){
            return "Plane Details is not available";
        }
    }
    @PutMapping("/plane")
    public String updatePlaneDetails(@RequestBody PlaneModel planeModel)
    {
        try{
            Plane planeDetailsToBeUpdated=planeRepository.findById(planeModel.getId()).get();
            if(planeModel.getPlaneModel()!=null&&!planeModel.getPlaneModel().isEmpty()) planeDetailsToBeUpdated.setPlaneModel(planeModel.getPlaneModel());
            if(planeModel.getPlaneMaker()!=null&&!planeModel.getPlaneMaker().isEmpty())planeDetailsToBeUpdated.setPlaneMaker(planeModel.getPlaneMaker());
            try{
                if(planeModel.getPlaneCapacity()>0){
                    planeDetailsToBeUpdated.setPlaneCapacity(planeModel.getPlaneCapacity());
                }
            }
            catch (InputMismatchException inputMismatchException){
                return "Not provided valid seating capacity";
            }
            planeRepository.save(planeDetailsToBeUpdated);
            return "Plane Details updated successfully";
        }
        catch(PlaneNotFoundException planeNotFoundException){
            return "Plane Details not updated for the provided Plane Id";
        }
        }
}
