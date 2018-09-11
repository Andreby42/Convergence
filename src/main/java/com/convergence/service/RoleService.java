package com.convergence.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.convergence.domain.RoleDTO;
import com.convergence.support.PageInfo;

public interface RoleService {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleDTO record);

    int insertSelective(RoleDTO record);

    RoleDTO selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleDTO record);

    int updateByPrimaryKey(RoleDTO record);

    Set<RoleDTO> selectRolesByUserId(String userId);

    /**
     * 给角色分配资源
     * 
     * @param id 角色ID
     * @param resourceIds 资源ids
     */
    void grant(Integer id, String[] resourceIds);

	List<RoleDTO> findAll();

	RoleDTO find(Integer id);

	PageInfo<RoleDTO> findAll(PageRequest pageRequest);

	void saveOrUpdate(RoleDTO role);

	void delete(Integer id);

}
