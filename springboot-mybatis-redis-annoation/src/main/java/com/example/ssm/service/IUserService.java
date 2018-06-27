package com.example.ssm.service;

import java.util.List;

import com.example.ssm.domain.User;

public interface IUserService {
	List<User> getAllUser();

	void insert(User user);

	void test();

	User getById(String userId);

	void delete(String userId);
}
