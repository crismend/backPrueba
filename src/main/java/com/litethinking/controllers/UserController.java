package com.litethinking.controllers;

import com.litethinking.entities.Product;
import com.litethinking.entities.User;
import com.litethinking.models.UserModel;
import com.litethinking.services.UserService;
import com.litethinking.util.BcryptGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BcryptGenerator bcryptGenerator;

    @PostMapping
    public ResponseEntity save (@RequestBody User usr){
        usr.setPass(bcryptGenerator.passwordEncoder(usr.getPass()));
        return new ResponseEntity(userService.save(usr), HttpStatus.CREATED);
    }

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity save (@RequestBody UserModel usr){
        System.out.println("ENTRAAA");
        User user = userService.login(usr);

        if(user == null){
            return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
        }else{
            if(!bcryptGenerator.passwordDecoder(usr.getPass(), user.getPass())){
                return new ResponseEntity("Las contraseñas no coinciden", HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity(user, HttpStatus.OK);

        }
    }

    @GetMapping
    public ResponseEntity getAll (){
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update (@RequestBody User usr){
        return new ResponseEntity(userService.save(usr), HttpStatus.ACCEPTED);
    }
}
