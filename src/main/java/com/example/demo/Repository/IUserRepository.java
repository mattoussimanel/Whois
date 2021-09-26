package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;



@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	 public User findByEmail(String email);
}
