package com.idtracks.gauges.service;

import java.io.IOException;

import com.idtracks.gauges.domain.User;


public interface UserService {
	
	/**
	 * Adds a new User
	 */
	public String  addUser(User user);
	
	
	/**
	 * Adds a new User
	 */
	public Boolean updateUser(User user);
	
	/**
	 * Retrieves a single person
	 */
	public User getUser(String userName, String password );
	
	public User findUserByOpenId(String openId);


	public String checkDuplicateEmail(String email);
	 
	 public byte[] getUserProfilePicture(String fileName);
}
