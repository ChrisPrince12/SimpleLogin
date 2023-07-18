package com.simplelogin.simplelogin.service;

import java.util.Optional;
import java.util.List;
import com.simplelogin.simplelogin.model.RealTechUser;

public interface RealTechUserService {
    RealTechUser registerUser(RealTechUser realTechUser);
    List<RealTechUser> listAllUsers();
    Optional<RealTechUser> findUserByEmail(String email);
    boolean checkPassword(String password, String hashcodePassword);
}
