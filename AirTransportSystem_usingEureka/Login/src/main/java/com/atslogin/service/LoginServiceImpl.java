package com.atslogin.service;

import com.atslogin.entity.LoginEntity;
import com.atslogin.model.LoginModel;
import com.atslogin.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class LoginServiceImpl implements LoginService{
    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository){
        this.loginRepository=loginRepository;
    }
    @Override
    public List<LoginModel> getAllLogin(){
        List<LoginEntity> allLogin = loginRepository.findAll();
        List<LoginModel> loginModelList = new ArrayList<>();
        for(LoginEntity loginEntity:allLogin){
            LoginModel loginModel = new LoginModel(
                    loginEntity.getId(),
                    loginEntity.getEmailId(),
                    loginEntity.getPassword(),
                    loginEntity.getPhoneNumber(),
                    loginEntity.getFailedAttempts(),
                    loginEntity.getLastAttemptTime(),
                    loginEntity.isLocked()
            );
            loginModelList.add(loginModel);
        }
        return loginModelList;
    }
    @Override
    public LoginModel getLoginById(Long id) {
        LoginEntity loginEntity = loginRepository.findById(id).orElse(null);
        if (loginEntity != null) {
            return new LoginModel(
                    loginEntity.getId(),
                    loginEntity.getEmailId(),
                    loginEntity.getPassword(),
                    loginEntity.getPhoneNumber(),
                    loginEntity.getFailedAttempts(),
                    loginEntity.getLastAttemptTime(),
                    loginEntity.isLocked()
            );
        }
        return null;
    }

    @Override
    public String login(LoginModel loginModel){
        validateEmail(loginModel.getEmailId());
        validatePassword(loginModel.getPassword());
        LoginEntity user = loginRepository.findByEmailId(loginModel.getEmailId());
        if(user == null){
            return "Invalid Email or Password";
        }
        if(user.isLocked()){
            if(user.getLastAttemptTime().plusSeconds(30).isBefore(LocalDateTime.now())){
                user.setLocked(false);
                user.setFailedAttempts(0);
                user.setLastAttemptTime(null);
                loginRepository.save(user);
            }
            else{
                return "Account is Locked. Please try again later";
            }
        }
        if(user.getPassword().equals(loginModel.getPassword())){
            user.setFailedAttempts(0);
            user.setLocked(false);
            user.setLastAttemptTime(null);
            loginRepository.save(user);
            return "Login Successful";
        }
        else {
            user.setFailedAttempts(user.getFailedAttempts() + 1);
            if(user.getFailedAttempts() >= 3){
                user.setLocked(true);
                user.setLastAttemptTime(LocalDateTime.now());
                loginRepository.save(user);
                return "Account is locked due to multiple failed login attempts";
            }
            else {
                loginRepository.save(user);
                return "Invalid Email or Password";
            }
        }
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
}