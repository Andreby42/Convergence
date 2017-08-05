package com.convergence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.convergence.domain.RoleDTO;

@Mapper
public interface RoleDao {
	int deleteByPrimaryKey(Integer roleId);

	int insert(RoleDTO record);

	int insertSelective(RoleDTO record);

	RoleDTO selectByPrimaryKey(Integer roleId);

	int updateByPrimaryKeySelective(RoleDTO record);

	int updateByPrimaryKey(RoleDTO record);

	List<RoleDTO> selectRolesByUserId(String userId);
}