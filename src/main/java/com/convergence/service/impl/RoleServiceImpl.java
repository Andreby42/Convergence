package com.convergence.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.convergence.dao.RoleDao;
import com.convergence.domain.RoleDTO;
import com.convergence.domain.UserDTO;
import com.convergence.service.RoleService;
import com.convergence.support.PageInfo;

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
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
	public List<RoleDTO> selectRolesByUserId(String userId) {
		return roleDao.selectRolesByUserId(userId);
	}

	@Override
	public void grant(Integer id, String[] resourceIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RoleDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO find(Integer id) {
		return roleDao.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<RoleDTO> findAll(PageRequest pageRequest) {
		int pageNo = pageRequest.getPageNumber();
		int offset = pageRequest.getPageSize();
		offset = (pageNo) * offset;
		int totalPages = roleDao.findTotalCount();
		List<RoleDTO> users = roleDao.findAll(offset, pageRequest.getPageSize());
		PageInfo<RoleDTO> page = new PageInfo<>();
		page.setContent(users);
		page.setNumber(offset);
		page.setTotalPages(
				totalPages == 0 ? 1 : (int) Math.ceil((double) totalPages / (double) pageRequest.getPageSize()));
		page.setPages(totalPages);
		return page;
	}

	@Override
	public void saveOrUpdate(RoleDTO role) {
		if (role.getRoleId() != null) {
			RoleDTO dbRole = find(role.getRoleId());
			dbRole.setName(role.getName());
			dbRole.setDescription(role.getDescription());
			dbRole.setUpdateTime(new Date());
			dbRole.setStatus(role.getStatus());
			roleDao.insertOrUpdate(dbRole);
		} else {
			role.setCreateTime(new Date());
			role.setUpdateTime(new Date());
			role.setStatus(0);
			roleDao.insertOrUpdate(role);
		}
		

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
