package com.example.hotelreservation.repository;


import com.example.hotelreservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


   Optional<User> findByPasswordAndEmail(String password, String email);

}
