package com.login.LoginWebServices.controller;

import com.login.LoginWebServices.models.User;
import com.login.LoginWebServices.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
           String tempEmailId =user.getEmailId();
           String tempPass=user.getPassword();
           User userObj=null;
           if (tempEmailId!=null && tempPass!=null){
                        userObj=loginService.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
           }
           if (userObj==null)       {
               throw new Exception("Invalid Credentials");
           }
             return userObj;
    }


}
