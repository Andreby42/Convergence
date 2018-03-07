package com.convergence.dao;

import org.apache.ibatis.annotations.Mapper;

import com.convergence.domain.UserDTO;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    UserDTO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);
}
