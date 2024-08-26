package com.atsairport.service;

import com.atsairport.entity.Airport;
import com.atsairport.model.AirportModel;
import com.atsairport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AirportServiceImpl implements AirportService {
   private final AirportRepository airportRepository;
   @Autowired
    public AirportServiceImpl(AirportRepository airportRepository)
   {
       this.airportRepository = airportRepository;
   }
   @Override
   public List<AirportModel> getAllPlanes() {
       List<Airport> allAirports = airportRepository.findAll();
       List<AirportModel> airportModelList = new ArrayList<>();
       for (Airport airportEntity : allAirports) {
           AirportModel airportModel = new AirportModel(airportEntity.getId(), airportEntity.getPlaneMaker(), airportEntity.getPlaneModel(), airportEntity.getPlaneCapacity());

           airportModelList.add(airportModel);
       }
       return airportModelList;
   }
    @Override
    public String generateId()
    {
        String planeId = airportRepository.findTopId();
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
