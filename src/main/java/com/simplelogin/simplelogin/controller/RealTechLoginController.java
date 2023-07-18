package com.simplelogin.simplelogin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplelogin.simplelogin.model.LoginRequest;
import com.simplelogin.simplelogin.model.RealTechUser;
import com.simplelogin.simplelogin.service.RealTechUserService;

@RestController
@RequestMapping("/auth")
public class RealTechLoginController {

    private final RealTechUserService realTechUserService;

    public RealTechLoginController(RealTechUserService realTechUserService) {
        super();
        this.realTechUserService = realTechUserService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginrequest){
        RealTechUser realTechUser = realTechUserService.findUserByEmail(loginrequest.getEmail()).orElseThrow(null);

        if(realTechUser != null && realTechUserService.checkPassword(loginrequest.getPassword(), realTechUser.getPassword())){
            return ResponseEntity.ok().build();
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
