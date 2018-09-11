package com.convergence.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.convergence.domain.RoleDTO;
import com.convergence.domain.RoleResourceDTO;

@Mapper
public interface RoleDao {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleDTO record);

    int insertSelective(RoleDTO record);

    RoleDTO selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleDTO record);

    int updateByPrimaryKey(RoleDTO record);

    Set<RoleDTO> selectRolesByUserId(String userId);

	int findTotalCount();

	List<RoleDTO> findAllByPage(@Param("offset")int offset,@Param("pageSize") int pageSize);

	void insertOrUpdate(RoleDTO role);
	
	void insertRoleAndResource(@Param("set")Set<RoleResourceDTO> resources);

	Set<RoleResourceDTO> selectResourceByRoleId(@Param("roleId")Integer roleId);

	void deleteRoleAndResources(@Param("roleId")Integer roleId);

	List<RoleDTO> findAll();
}
