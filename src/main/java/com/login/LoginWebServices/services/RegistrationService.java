package com.login.LoginWebServices.services;

import com.login.LoginWebServices.models.User;
import com.login.LoginWebServices.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;

    public User saveUser(User user){
        return repo.save(user);

    }
    public User fetchUserByEmailId(String email){
        return repo.findByEmailId(email);
    }
}
