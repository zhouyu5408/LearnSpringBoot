package com.example.ssm.dao;

import java.util.List;

import com.example.ssm.domain.User;

public interface UserMapper {

	int deleteByPrimaryKey(String userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> getAllUserList();
}