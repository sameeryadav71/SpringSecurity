package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.domain.User;
import com.web.service.UserService;

/**
 * 
 * @author s.yadav
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/welcome")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User updated = userService.saveUser(user);
        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id")Integer id, @RequestBody User user) {
		User userData = userService.updateUser(id, user);
		return new ResponseEntity<User>(userData, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> list = userService.findAllUsers();
		return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getUserByName/{userName}")
	public ResponseEntity<User> findByUserName(@PathVariable("userName") String userName) {
		User entity = userService.findByUserName(userName);
		return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	
}
