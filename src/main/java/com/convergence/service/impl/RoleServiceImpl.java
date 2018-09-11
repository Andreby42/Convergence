package com.convergence.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.convergence.dao.ResourceDao;
import com.convergence.dao.RoleDao;
import com.convergence.domain.ResourceDTO;
import com.convergence.domain.RoleDTO;
import com.convergence.domain.RoleResourceDTO;
import com.convergence.service.RoleService;
import com.convergence.support.PageInfo;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	@Resource
	private ResourceDao resourceDao;

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
	public Set<RoleDTO> selectRolesByUserId(String userId) {
		return roleDao.selectRolesByUserId(userId);
	}

	@Override
	public void grant(Integer roleId, String[] resourceIds) {
		RoleDTO role = find(roleId);

		Assert.notNull(role, "角色不存在");
		// Assert.state(!"administrator".equals(role.getRoleKey()), "超级管理员角色不能进行资源分配");
		// 暴力点先 干掉之前的所有的权限资源。
		roleDao.deleteRoleAndResources(roleId);
		Set<RoleResourceDTO> resources = new HashSet<RoleResourceDTO>();
		if (resourceIds != null) {
			for (int i = 0; i < resourceIds.length; i++) {
				RoleResourceDTO rr = new RoleResourceDTO();
				if (StringUtils.isBlank(resourceIds[i]) || "-1".equals(resourceIds[i])) {
					continue;
				}
				Integer resourceId = Integer.parseInt(resourceIds[i]);
				rr.setResourceId(resourceId);
				rr.setRoleId(roleId);
				resources.add(rr);
			}
		}
		roleDao.insertRoleAndResource(resources);
	}

	@Override
	public List<RoleDTO> findAll() {
		return roleDao.findAll();
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
		List<RoleDTO> users = roleDao.findAllByPage(offset, pageRequest.getPageSize());
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
