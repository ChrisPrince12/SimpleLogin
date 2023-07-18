package com.simplelogin.simplelogin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplelogin.simplelogin.model.RealTechUser;
import com.simplelogin.simplelogin.repository.RealTechUserRepository;

@Service
public class RealTechUserServiceImpl implements RealTechUserService{

    private final RealTechUserRepository realTechUserRepository;
    private final PasswordEncoder passwordEncoder;

    private RealTechUserServiceImpl(RealTechUserRepository realTechUserRepository, PasswordEncoder passwordEncoder){
        super();
        this.realTechUserRepository = realTechUserRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public RealTechUser registerUser(RealTechUser realTechUser) {
       realTechUser.setPassword(passwordEncoder.encode(realTechUser.getPassword()));
       return realTechUserRepository.save(realTechUser);
    }

    @Override
    public List<RealTechUser> listAllUsers() {
       return realTechUserRepository.findAll();
    }

    @Override
    public Optional<RealTechUser> findUserByEmail(String email) {
       return realTechUserRepository.findByEmail(email);
    }
    
    @Override
	public boolean checkPassword(String password, String hashcodePassword) {
		return BCrypt.checkpw(password, hashcodePassword);
	}
}
