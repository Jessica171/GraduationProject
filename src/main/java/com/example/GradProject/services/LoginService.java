package com.example.GradProject.services;

import com.example.GradProject.Repository.UserRepo;
import com.example.GradProject.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Valid
public class LoginService {
    @Autowired
    UserRepo userRepo;

    public String checkUser(String email, String password) {
        Optional<Users> optionalUser = userRepo.findById(email);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                return "Authentication successful";
            }

        }
        return "Either the email or password you entered is incorrect";
    }


    public String addUser(Users users) {
        String fullname = users.getFullname();
        String email = users.getEmail();
        String password = users.getPassword();
        String phoneNumber = users.getPhonenumber();
        boolean emailExists = userRepo.existsById(email);
        if (emailExists) {
            return "Email already registered";

        }
            userRepo.save(users);
            return "succ added ";
        }


        public List<Users> getAllUsers () {

            return userRepo.findAll();


        }

        public String deleteUsers () {
            userRepo.deleteAll();
            return "Deleted";
        }
    }
