package com.itheima.crm.dao;

import com.itheima.crm.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

	private List<User> users = new ArrayList<>();

	@Override
	public void save(User user) {
		users.add(user);
	}

	@Override
	public User findOne(String username, String password) {
		User userTmp = new User();
		userTmp.setUsername(username);
		userTmp.setPassword(password);

		for(User user : users) {
			if(user.matchUsernameAndPassword(username, password)) {
				return user;
			}
		}

		return null;
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	public UserDaoImpl() {
		// 添加一些测试的用户
		User user1 = new User();
		user1.setId(1);
		user1.setUsername("zhangsan");
		user1.setPassword("0");

		User user2 = new User();
		user2.setId(2);
		user2.setUsername("lisi");
		user2.setPassword("0");

		User user3 = new User();
		user3.setId(3);
		user3.setUsername("wangwu");
		user3.setPassword("0");

		User user4 = new User();
		user4.setId(4);
		user4.setUsername("zhaoliu");
		user4.setPassword("0");

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}
}
