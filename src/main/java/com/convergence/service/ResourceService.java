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
}
