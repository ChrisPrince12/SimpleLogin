package com.simplelogin.simplelogin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simplelogin.simplelogin.model.RealTechUser;
import com.simplelogin.simplelogin.service.RealTechUserService;

@RestController
@RequestMapping("/spring")
public class RealTechUserController {
    private final RealTechUserService realTechUserService;

    public RealTechUserController(RealTechUserService realTechUserService){
        super();
        this.realTechUserService = realTechUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RealTechUser realTechUser){
           Optional<RealTechUser> existingUser = realTechUserService.findUserByEmail(realTechUser.getEmail());
           if(existingUser.isPresent()){
             return ResponseEntity.badRequest().body("Email Already Exist");
           }

           RealTechUser newRealTechUser = realTechUserService.registerUser(realTechUser);
           return ResponseEntity.ok(newRealTechUser);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<RealTechUser>> getAllUsers(){
        List<RealTechUser> users = realTechUserService.listAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
