package com.atsadmin.service;

import com.atsadmin.model.AdministratorModel;

import java.util.List;

public interface AdministratorService {
    String newAdministrator(AdministratorModel administratorModel);
    List<AdministratorModel>getAllAdministrator();
    AdministratorModel getAdministratorById(Long id);
}
