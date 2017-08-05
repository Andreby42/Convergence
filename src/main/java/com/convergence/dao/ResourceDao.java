package com.convergence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.convergence.domain.ResourceDTO;

@Mapper
public interface ResourceDao {
	int deleteByPrimaryKey(Integer reourceId);

	int insert(ResourceDTO record);

	int insertSelective(ResourceDTO record);

	ResourceDTO selectByPrimaryKey(Integer reourceId);

	int updateByPrimaryKeySelective(ResourceDTO record);

	int updateByPrimaryKey(ResourceDTO record);

	List<ResourceDTO> selectResourcesByRoleId(String userId);
}