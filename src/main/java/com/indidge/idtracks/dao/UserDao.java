package com.indidge.idtracks.dao;

import com.indidge.idtracks.model.User;

public interface UserDao {

	User findByUserName(String username);

}