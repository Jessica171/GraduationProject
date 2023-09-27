package com.example.GradProject.controller;

import com.example.GradProject.entities.Users;
import com.example.GradProject.models.LoginRequest;

import com.example.GradProject.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String loginAuthenticate(@Valid @RequestBody LoginRequest loginRequest) {
        return loginService.checkUser(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String signupAuthenticate(@Valid @RequestBody Users signUpRequest) {
        return loginService.addUser(signUpRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUsers")
    public List<Users> signupAuthenticate() {
        return loginService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteUsers")
    public String deleteUsers() {
        return loginService.deleteUsers();
    }

}
