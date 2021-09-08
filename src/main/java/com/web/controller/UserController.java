package com.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author s.yadav
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/welcome")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}

}
