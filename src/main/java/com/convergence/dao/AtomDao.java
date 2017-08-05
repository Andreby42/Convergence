package com.convergence.dao;

import org.apache.ibatis.annotations.Mapper;

import com.convergence.domain.AtomDTO;

@Mapper
public interface AtomDao {
	int deleteByPrimaryKey(Integer atomId);

	int insert(AtomDTO record);

	int insertSelective(AtomDTO record);

	AtomDTO selectByPrimaryKey(Integer atomId);

	int updateByPrimaryKeySelective(AtomDTO record);

	int updateByPrimaryKey(AtomDTO record);
}