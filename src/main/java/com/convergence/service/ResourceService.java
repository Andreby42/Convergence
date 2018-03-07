package com.convergence.service;

import java.util.List;

import com.convergence.domain.ResourceDTO;

public interface ResourceService {
    int deleteByPrimaryKey(Integer reourceId);

    int insert(ResourceDTO record);

    int insertSelective(ResourceDTO record);

    ResourceDTO selectByPrimaryKey(Integer reourceId);

    int updateByPrimaryKeySelective(ResourceDTO record);

    int updateByPrimaryKey(ResourceDTO record);

    List<ResourceDTO> selectResourcesByRoleId(String userId);

    List<ResourceDTO> findAll();

    /**
     * 获取角色的权限树
     * 
     * @param roleId
     * @return
     */
    List<com.convergence.domain.vo.ZtreeView> tree(int roleId);

}
