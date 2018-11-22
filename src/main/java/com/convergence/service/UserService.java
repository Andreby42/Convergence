package com.convergence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.convergence.domain.UserDTO;
import com.convergence.support.PageInfo;

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
     * 
     * @param id 用户ID
     * @param roleIds 角色Ids
     */
    void grant(Integer id, String[] roleIds);

	void delete(Integer id);

	PageInfo<UserDTO> findAll(PageRequest pageRequest);

	UserDTO find(Integer id);

	void saveOrUpdate(UserDTO user);

	void updatePwd(UserDTO principal, String oldPassword, String password1, String password2);

	void UpdateDeleteStatus(Integer id);


}
