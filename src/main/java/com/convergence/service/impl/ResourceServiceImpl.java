package com.convergence.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.convergence.dao.ResourceDao;
import com.convergence.domain.ResourceDTO;
import com.convergence.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {
	@Resource
	private ResourceDao resourceDao;

	@Override
	@Transactional
	public int deleteByPrimaryKey(Integer reourceId) {
		return resourceDao.deleteByPrimaryKey(reourceId);
	}

	@Override
	@Transactional
	public int insert(ResourceDTO record) {
		return resourceDao.insert(record);
	}

	@Override
	@Transactional
	public int insertSelective(ResourceDTO record) {
		return resourceDao.insertSelective(record);
	}

	@Override
	@Transactional(readOnly = true)
	public ResourceDTO selectByPrimaryKey(Integer reourceId) {
		return resourceDao.selectByPrimaryKey(reourceId);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(ResourceDTO record) {
		return resourceDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(ResourceDTO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ResourceDTO> selectResourcesByRoleId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
