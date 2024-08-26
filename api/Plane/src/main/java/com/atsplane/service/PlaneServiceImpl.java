package com.atsplane.service;

import com.atsplane.entity.Plane;
import com.atsplane.model.PlaneModel;
import com.atsplane.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PlaneServiceImpl implements PlaneService{
   private final PlaneRepository planeRepository;
   @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository)
   {
       this.planeRepository=planeRepository;
   }
   @Override
   public List<PlaneModel> getAllPlanes() {
       List<Plane> allPlanes = planeRepository.findAll();
       List<PlaneModel> planeModelList = new ArrayList<>();
       for (Plane planeEntity : allPlanes) {
           PlaneModel planeModel = new PlaneModel(planeEntity.getId(),planeEntity.getPlaneMaker(), planeEntity.getPlaneModel(),planeEntity.getPlaneCapacity());

           planeModelList.add(planeModel);
       }
       return planeModelList;
   }
    @Override
    public String generateId()
    {
        String planeId = planeRepository.findTopId();
        if (planeId == null || planeId.isEmpty()) {
            planeId = "PL0000";
        }
        String id="PL";
        int num=Integer.parseInt(planeId.substring(2,6));
        num++;
        String digit=Integer.toString(num);
        switch(4-digit.length()){
            case 1:
                id+="0";
                break;
            case 2:
                id+="00";
                break;
            case 3:
                id+="000";
                break;
            default:
                break;
        }
        id+=digit;
        return id;
    }
}
