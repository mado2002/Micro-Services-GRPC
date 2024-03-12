package com.example.ratingsservice.Repositories;

import com.example.ratingsservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository extends JpaRepository <User, String>{
}
