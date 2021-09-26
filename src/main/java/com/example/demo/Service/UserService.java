package com.example.demo.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.IRoleRepository;
import com.example.demo.Repository.IUserRepository;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;




@Service("userService")
public class UserService {
	private IUserRepository userRepository;
	private IRoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	
	public UserService(IUserRepository userRepository,IRoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder)
	{
		this.userRepository= userRepository;
	this.roleRepository= roleRepository;
	this.bCryptPasswordEncoder= bCryptPasswordEncoder;
	}
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
		}

	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole= roleRepository.findByRole("USER");
		user.setRoles(new HashSet <Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
}



