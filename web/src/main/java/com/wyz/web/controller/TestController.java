package com.wyz.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyz.web.entity.User;
import com.wyz.web.service.db1.UserService;
import com.wyz.web.service.db2.UserService2;

@Controller
public class TestController {

	@Autowired
	protected UserService u1;
	
	@Autowired
	protected UserService2 u2;
	
	@RequestMapping("/add")
	@ResponseBody
	public String show(
			@RequestParam(defaultValue = "0") Integer type
			){
		try {
			User user = new User();
			user.setBalance(Double.valueOf(type));
			user.setSex(1);
			user.setStatus(1);
			user.setSource(1);
			user.setIcon("type"+type);
			user.setOpenid("open");
			user.setWxappid("test");
			user.setCreateTime(new Date());
			user.setNickname("nickname");
			if(type == 1){
				this.u2.insert(user);
			}else{
				this.u1.insert(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "test";
	}
}
