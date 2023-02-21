package com.revature.facespace.repository;

import com.revature.facespace.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmailAddressAndPassword(String emailAddress, String password);
}
