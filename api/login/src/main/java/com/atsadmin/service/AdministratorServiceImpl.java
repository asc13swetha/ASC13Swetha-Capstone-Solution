package com.atsadmin.service;

import com.atsadmin.entity.AdministratorEntity;
import com.atsadmin.model.AdministratorModel;
import com.atsadmin.repository.AdministratorRepository;
import com.atsadmin.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository){
        this.administratorRepository=administratorRepository;
    }

    @Override
    public String newAdministrator(AdministratorModel newUserRequest) {
        validateEmail(newUserRequest.getEmailId());
        validatePassword(newUserRequest.getPassword());
        if (administratorRepository.findByEmailId(newUserRequest.getEmailId()) != null) {
            return "Email already Exists.";
        }
        if (administratorRepository.findByPhoneNumber(newUserRequest.getPhoneNumber()) != null) {
            return "Phone already Exists.";
        }

        AdministratorEntity administratorEntity = new AdministratorEntity();
        administratorEntity.setId(newUserRequest.getId());
        administratorEntity.setEmailId(newUserRequest.getEmailId());
        administratorEntity.setPassword(newUserRequest.getPassword());
        administratorEntity.setPhoneNumber(newUserRequest.getPhoneNumber());
        administratorEntity.setFailedAttempts(0);
        administratorEntity.setLocked(false);
        administratorRepository.save(administratorEntity);
        return "Registration Successful";
    }



    private void validateEmail(String emailId){
        if(emailId == null || emailId.isEmpty() || !emailId.matches("^[a-zA-Z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("Invalid Email Address");
        }
    }

    private void validatePassword(String password){
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/~]).+$";
        Pattern pattern = Pattern.compile(regex);

        if (!pattern.matcher(password).matches()) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character (e.g., !, @, #, $, %, &, *, etc.)");
        }
    }

    @Override
    public List<AdministratorModel> getAllAdministrator(){
        List<AdministratorEntity> allAdministrators = administratorRepository.findAll();
        List<AdministratorModel> administratorModelList = new ArrayList<>();
        for(AdministratorEntity administratorEntity:allAdministrators){
            AdministratorModel administratorModel = new AdministratorModel(
                    administratorEntity.getId(),
                    administratorEntity.getEmailId(),
                    administratorEntity.getPassword(),
                    administratorEntity.getPhoneNumber(),
                    administratorEntity.getFailedAttempts(),
                    administratorEntity.getLastAttemptTime(),
                    administratorEntity.isLocked()
            );
            administratorModelList.add(administratorModel);
        }
        return administratorModelList;
    }
    @Override
    public AdministratorModel getAdministratorById(Long id) {
        AdministratorEntity administratorEntity = administratorRepository.findById(id).orElse(null);
        if (administratorEntity != null) {
            return new AdministratorModel(
                    administratorEntity.getId(),
                    administratorEntity.getEmailId(),
                    administratorEntity.getPassword(),
                    administratorEntity.getPhoneNumber(),
                    administratorEntity.getFailedAttempts(),
                    administratorEntity.getLastAttemptTime(),
                    administratorEntity.isLocked()
            );
        }
        return null;
    }
}