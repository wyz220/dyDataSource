package com.wyz.web.dao.db1;

import org.apache.ibatis.annotations.Mapper;

import com.wyz.web.dao.CrudDao;
import com.wyz.web.entity.User;


@Mapper
public interface UserMapper extends CrudDao<User>{

}