package com.backend.revision.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.revision.models.*;
import com.backend.revision.repository.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userRepository.findAll());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") long id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(user);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userRepository.save(user);
		return ResponseEntity.ok(createdUser);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id,@RequestBody User user) {
		Optional<User> userData = userRepository.findById(id);
		
		if(userData.isPresent()) {
			User _user = userData.get();
			_user.setFullnames(user.getFullnames());
			_user.setEmail(user.getEmail());
			_user.setNID(user.getNID());
			_user.setPhoneNumber(user.getPhoneNumber());
			_user.setAddress(user.getAddress());
			_user.setUsername(user.getUsername());
			_user.setPassword(user.getPassword());
			
			return ResponseEntity.ok(userRepository.save(_user));
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		userRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
