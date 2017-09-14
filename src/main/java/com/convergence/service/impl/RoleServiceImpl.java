package com.convergence.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.convergence.dao.RoleDao;
import com.convergence.domain.RoleDTO;
import com.convergence.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;

	@Override
	@Transactional
	public int deleteByPrimaryKey(Integer roleId) {
		return roleDao.deleteByPrimaryKey(roleId);
	}

	@Override
	@Transactional
	public int insert(RoleDTO record) {
		return roleDao.insert(record);
	}

	@Override
	@Transactional
	public int insertSelective(RoleDTO record) {
		return roleDao.insertSelective(record);
	}

	@Override
	@Transactional(readOnly=true)
	public RoleDTO selectByPrimaryKey(Integer roleId) {
		return roleDao.selectByPrimaryKey(roleId);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(RoleDTO record) {
		return roleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional
	public int updateByPrimaryKey(RoleDTO record) {
		return roleDao.updateByPrimaryKey(record);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleDTO> selectRolesByUserId(String userId) {
		return roleDao.selectRolesByUserId(userId);
	}

	@Override
	public void grant(Integer id, String[] resourceIds) {
		// TODO Auto-generated method stub
		
	}

}
