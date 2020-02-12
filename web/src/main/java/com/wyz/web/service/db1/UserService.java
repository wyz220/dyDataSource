package com.wyz.web.service.db1;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wyz.web.dao.db1.UserMapper;
import com.wyz.web.entity.Page;
import com.wyz.web.entity.User;
import com.wyz.web.exception.BusinessException;
import com.wyz.web.service.CrudService;


@Service
@Transactional(readOnly = false)
public class UserService extends CrudService<UserMapper, User>{

	@Autowired
	protected UserMapper dao;
	
	public Page<User> page(User entity) throws BusinessException{
		entity.getPage().setCount(this.dao.count(entity));
		entity.getPage().setList(this.dao.page(entity));
		return entity.getPage();
	}

	public int updateUser(User u) throws BusinessException{
		User param = new User();
		param.setOpenid(u.getOpenid());
		if(null != u.getOpenid()) param = this.dao.get(param);
		
		if(null == u.getOpenid() || null == param){
			u.setBalance(0.0);
			u.setStatus(1);//有效
			u.setCreateTime(new Date());
			int i = this.dao.insert(u);
			
			return i;
		}else{
			u.setId(param.getId());
			u.setUpdateTime(new Date());
			return this.dao.update(u);
		}
	}

	
}
