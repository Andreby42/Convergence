package com.convergence.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.convergence.domain.ResourceDTO;

@Mapper
public interface ResourceDao {
	int deleteByPrimaryKey(Integer reourceId);

	int insert(ResourceDTO record);

	int insertSelective(ResourceDTO record);

	ResourceDTO selectByPrimaryKey(Integer reourceId);

	int updateByPrimaryKeySelective(ResourceDTO record);

	int updateByPrimaryKey(ResourceDTO record);

	Set<ResourceDTO> selectResourcesByRoleId(String userId);

	List<ResourceDTO> findAllWithParams(@Param("offset") int offset, @Param("pageSize") int pageSize);

	int findTotalCount();

	void insertOrUpdate(ResourceDTO resource);

	ResourceDTO selectResourcesByParentId(int parentId);

	List<ResourceDTO> findAll();

	List<ResourceDTO> findAllForShiro();
}
