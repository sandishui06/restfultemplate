package com.itheima.crm.webservice;

import com.itheima.crm.domain.ResResult;
import com.itheima.crm.domain.User ;
import com.itheima.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestService {

	@Autowired
	private UserService userService;

	/**
	 * 注册服务
	 * @param user 用户
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResResult regist(@RequestBody User user) {
		try {
			userService.regist(user);
			return new ResResult(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResResult(false, "添加失败");
		}
	}

	/**
	 * 登录服务
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping(value = "/{username}/{password}", method = RequestMethod.GET)
	public User login(@PathVariable("username") String username, @PathVariable("password") String password) {
		try {
			return userService.login(username, password);
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return userService.findAll();
	}
}
