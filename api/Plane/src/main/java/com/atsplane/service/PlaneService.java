package com.atsplane.service;

import com.atsplane.model.PlaneModel;

import java.util.List;

public interface PlaneService {
    String generateId();
    List<PlaneModel> getAllPlanes();
}
