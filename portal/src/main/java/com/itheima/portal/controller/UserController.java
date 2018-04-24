package com.itheima.portal.controller;

import com.itheima.crm.domain.ResResult;
import com.itheima.crm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	private String USERSERVICE_URL = "http://localhost:9001/user";

	@RequestMapping("/login")
	public Map login(String username, String password) {
		Map<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);

		User user = restTemplate.getForObject(USERSERVICE_URL + "/{username}/{password}", User.class, params);
		Map<String, Object> result = new HashMap<>();
		if(user != null) {
			 result.put("success", true);
		}
		else {
			result.put("success", false);
			result.put("message", "登录失败");
		}

		return result;
	}

	@RequestMapping("/regist")
	public ResResult login(@RequestBody  User user) throws IOException {
		return restTemplate.postForObject(USERSERVICE_URL + "/", user, ResResult.class);
	}
}
