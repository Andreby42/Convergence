package com.convergence.dao;

import com.convergence.domain.AtomDTO;

public interface AtomDao {
    int deleteByPrimaryKey(Integer atomId);

    int insert(AtomDTO record);

    int insertSelective(AtomDTO record);

    AtomDTO selectByPrimaryKey(Integer atomId);

    int updateByPrimaryKeySelective(AtomDTO record);

    int updateByPrimaryKey(AtomDTO record);
}