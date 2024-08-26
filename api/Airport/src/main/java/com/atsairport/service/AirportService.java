package com.atsairport.service;

import com.atsairport.model.AirportModel;

import java.util.List;

public interface AirportService {
    String generateId();
    List<AirportModel> getAllPlanes();
}
