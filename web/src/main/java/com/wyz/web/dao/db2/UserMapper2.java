package com.wyz.web.dao.db2;

import org.apache.ibatis.annotations.Mapper;

import com.wyz.web.dao.CrudDao;
import com.wyz.web.entity.User;


@Mapper
public interface UserMapper2 extends CrudDao<User>{

}