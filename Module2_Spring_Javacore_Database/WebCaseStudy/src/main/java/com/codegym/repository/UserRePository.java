package com.codegym.repository;

import com.codegym.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRePository extends JpaRepository< User,Integer>
{
    User findByUsername(String username);
}

