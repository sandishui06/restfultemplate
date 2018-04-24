package com.itheima.crm.service;

import com.itheima.crm.dao.UserDao;
import com.itheima.crm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public void regist(User user) {
		userDao.save(user);
	}

	@Override
	public User login(String username, String password) {
		return userDao.findOne(username, password);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
}
