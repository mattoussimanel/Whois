package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Role;



@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>{
	public Role findByRole(String role);
}
