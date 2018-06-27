package com.example.ssm.dao;

import com.example.ssm.domain.Order;

public interface OrderMapper {

	int deleteByPrimaryKey(String orderId);

	int insert(Order record);

	int insertSelective(Order record);

	Order selectByPrimaryKey(String orderId);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);
}