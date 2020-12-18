package com.login.LoginWebServices.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class ImageUploadHelper {

    //public final String UPLOAD_DIR="E:\\LoginWebServices\\src\\main\\resources\\static\\image";
    public final String UPLOAD_DIR=new ClassPathResource("/static/image/").getFile().getAbsolutePath();

    public ImageUploadHelper() throws IOException {
    }

    public boolean uploadFile(MultipartFile multipartFile){

        boolean f =false;
        try{
            InputStream is= multipartFile.getInputStream();
            byte [] data= new byte[is.available()];
            is.read(data);
            FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
            fos.write(data);

            fos.flush();
            fos.close();
            is.close();

            f=true;

            //new way of doing above task
            //Files.copy(inputstream, path of upload dir, copy option)
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);


        }catch (IOException e){
            e.printStackTrace();
        }
            return f;
    }

}
