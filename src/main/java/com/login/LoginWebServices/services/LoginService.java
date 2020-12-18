package com.login.LoginWebServices.services;

import com.login.LoginWebServices.models.User;
import com.login.LoginWebServices.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository repository;

    public User fetchUserByEmailIdAndPassword(String emailId, String password){
        return repository.findByEmailIdAndPassword(emailId,password);
    }
}
