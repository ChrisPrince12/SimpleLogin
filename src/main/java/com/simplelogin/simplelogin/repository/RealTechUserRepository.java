package com.simplelogin.simplelogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplelogin.simplelogin.model.RealTechUser;


public interface RealTechUserRepository extends JpaRepository<RealTechUser, Long>{
    Optional<RealTechUser> findByEmail(String email);
}
