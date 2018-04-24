package com.itheima.crm.service;

import com.itheima.crm.domain.User ;

import java.util.List;

public interface UserService {
	void regist(User user);

	User login(String username, String password);

	List<User> findAll();
}
