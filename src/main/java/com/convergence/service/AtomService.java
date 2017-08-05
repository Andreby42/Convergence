package com.convergence.service;

import com.convergence.domain.AtomDTO;

public interface AtomService {
	int deleteByPrimaryKey(Integer atomId);

	int insert(AtomDTO record);

	int insertSelective(AtomDTO record);

	AtomDTO selectByPrimaryKey(Integer atomId);

	int updateByPrimaryKeySelective(AtomDTO record);

	int updateByPrimaryKey(AtomDTO record);
}
