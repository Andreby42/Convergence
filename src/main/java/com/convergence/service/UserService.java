package com.convergence.service;

import com.convergence.domain.UserDTO;

public interface UserService {
	int deleteByPrimaryKey(Integer userId);

	int insert(UserDTO record);

	int insertSelective(UserDTO record);

	UserDTO selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(UserDTO record);

	int updateByPrimaryKey(UserDTO record);

	UserDTO findByUserName(String username);

	/**
	 * 给用户分配角色
	 * @param id 用户ID
	 * @param roleIds 角色Ids
	 */
	void grant(Integer id, String[] roleIds);
}
