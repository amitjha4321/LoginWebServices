package com.login.LoginWebServices.controller;

import com.google.gson.Gson;
import com.login.LoginWebServices.models.FileInfo;
import com.login.LoginWebServices.models.User;
import com.login.LoginWebServices.services.RegistrationService;
import com.login.LoginWebServices.utils.ImageUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService service;

//    @Autowired
//    ImageUploadHelper imageUploadHelper;

   @PostMapping("/register")
   public ResponseEntity<User> register (User user){

       service.saveUser(user);

       System.out.println("done done done ");

       return new ResponseEntity<>(user,HttpStatus.OK);
   }

    //@PostMapping("/registeruser")
    //@PostMapping(path = "/registeruser", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    @PostMapping(path = "/registerwithimage")
    public ResponseEntity<User> registerUser(@RequestParam("userinfo") String userString, @RequestParam("image") MultipartFile image) throws Exception {
        Gson gson = new Gson();

        // Converting json to object
        // first parameter should be preprocessed json
        // and second should be mapping class
        User user
                = gson.fromJson(userString,
                User.class);
        String tempEmailId=user.getEmailId();
        if (tempEmailId!=null && !"".equals(tempEmailId)){
            User userObj =service.fetchUserByEmailId(tempEmailId);
            if (userObj!=null){
                throw new Exception("User with email: " +tempEmailId +" already exists");
            }
        }
        User userObj= null;
        user.setFileName(image.getOriginalFilename());
        userObj=service.saveUser(user);



        return new ResponseEntity<>(user ,HttpStatus.OK);
       // return new  ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping("/userprofileimageupload")
//    public ResponseEntity<String> userProfileImageUpload(@RequestParam("image") MultipartFile userImage){
//        return ResponseEntity.ok("image uploaded successfully");
//
//    }

    @PostMapping("/imageupload")
    public ResponseEntity<FileInfo> userProfileImageUpload(@RequestParam("image") MultipartFile userImage){
        // file/image validations
        //file empty
        if (userImage.isEmpty()){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        //imageUploadHelper.uploadFile(userImage);

        FileInfo fileInfo= new FileInfo();
        fileInfo.setFilename(userImage.getOriginalFilename());
        fileInfo.setFilesize(userImage.getSize());
        System.out.println("Finally got some thing to smile at!!!!");
        return new ResponseEntity<>(fileInfo,HttpStatus.OK);

    }
}
