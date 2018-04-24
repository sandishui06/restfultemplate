package com.itheima.crm.dao;

import com.itheima.crm.domain.User ;

import java.util.List;

public interface UserDao {
	/**
	 * 保存用户
	 * @param user 用户
	 */
	void save(User user);

	User findOne(String username, String password);

	List<User> findAll();
}
