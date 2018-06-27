package com.example.ssm.dao;

import com.example.ssm.domain.Commodity;

public interface CommodityMapper {

	int deleteByPrimaryKey(String commodityId);

	int insert(Commodity record);

	int insertSelective(Commodity record);

	Commodity selectByPrimaryKey(String commodityId);

	int updateByPrimaryKeySelective(Commodity record);

	int updateByPrimaryKey(Commodity record);
}