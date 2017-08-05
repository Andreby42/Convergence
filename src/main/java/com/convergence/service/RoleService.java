package com.convergence.service;

import java.util.List;

import com.convergence.domain.RoleDTO;

public interface RoleService {
	int deleteByPrimaryKey(Integer roleId);

	int insert(RoleDTO record);

	int insertSelective(RoleDTO record);

	RoleDTO selectByPrimaryKey(Integer roleId);

	int updateByPrimaryKeySelective(RoleDTO record);

	int updateByPrimaryKey(RoleDTO record);

	List<RoleDTO> selectRolesByUserId(String userId);
}
