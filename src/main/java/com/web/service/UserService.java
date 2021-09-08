package com.web.service;

import java.util.List;

import com.web.domain.User;

/**
 * 
 * @author s.yadav
 *
 */
public interface UserService {
	
	public User saveUser(User user);
	public User updateUser(Integer id, User user) ;
	public void deleteUser(Integer id);
	public User findUserById(Integer id) ;
	public User findByUserName(String userName) ;
	public List<User> findAllUsers();

}
