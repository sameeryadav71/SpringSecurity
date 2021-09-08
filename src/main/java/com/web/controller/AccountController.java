package com.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.domain.User;
import com.web.service.UserService;
import com.web.util.CustomErrorType;

/**
 * 
 * @author s.yadav
 *
 */
@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	private UserService userService;
	
    @GetMapping("/hello")
    public String home() {
        return ("<h1>Welcome</h1>");
    }
    
	@GetMapping("/test")
    public String test() {
    	return "test";
    }
	
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@CrossOrigin
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody User newUser) throws Exception {
		if (userService.findByUserName(newUser.getUserName()) != null) {
			System.out.print("username Already exist " + newUser.getUserName());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUserName() + " already exist "),
					HttpStatus.CONFLICT);
		}
		newUser.setRoles("ROLE_USER");
		newUser.setActive(true);
		
		return new ResponseEntity<User>(userService.saveUser(newUser), HttpStatus.CREATED);
	}
    
    @CrossOrigin
	@RequestMapping("/login")
	public Principal user(Principal principal) {
		System.out.print("user logged "+principal);
		return principal;
	}
}