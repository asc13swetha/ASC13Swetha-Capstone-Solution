package com.atslogin.controller;
import com.atslogin.exceptions.UserNotFoundException;
import com.atslogin.model.LoginModel;
import com.atslogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {

        this.loginService = loginService;
    }

    @GetMapping("/login")
    public List<LoginModel> getAllLoginDetails() {
        return loginService.getAllLogin();

    }

    @GetMapping("/login/{id}")
    public LoginModel getLogin(@PathVariable Long id) {
        try {
            return loginService.getLoginById(id);
        } catch (UserNotFoundException userNotFoundException) {
            return null;
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginModel loginRequest) {
        return loginService.login(loginRequest);
    }
}
