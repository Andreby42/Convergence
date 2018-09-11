package com.convergence.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.convergence.dao.ResourceDao;
import com.convergence.dao.RoleDao;
import com.convergence.domain.ResourceDTO;
import com.convergence.domain.RoleDTO;
import com.convergence.domain.vo.ZtreeView;
import com.convergence.service.ResourceService;
import com.convergence.support.PageInfo;

@Service
public class ResourceServiceImpl implements ResourceService {
	@Resource
	private ResourceDao resourceDao;
	@Resource
	private RoleDao roleDao;

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
	public Set<ResourceDTO> selectResourcesByRoleId(String userId) {
		return resourceDao.selectResourcesByRoleId(userId);
	}

	@Override
	public List<ZtreeView> tree(int roleId) {
		List<ZtreeView> resultTreeNodes = new ArrayList<ZtreeView>();
		RoleDTO role = roleDao.selectByPrimaryKey(roleId);
		Set<ResourceDTO> roleResources = role.getResources();
		resultTreeNodes.add(new ZtreeView(-1L, null, "系统菜单", true));
		ZtreeView node;
		List<ResourceDTO> all = resourceDao.findAllByOrderByParentAscIdAscSortAsc();
		for (ResourceDTO resource : all) {
			node = new ZtreeView();
			node.setId(Long.valueOf(resource.getResourceId()));
			if (resource.getParent() == null) {
				node.setpId(-1L);
			} else {
				node.setpId(Long.valueOf(resource.getParent().getResourceId()));
			}
			node.setName(resource.getName());
			if (roleResources != null && roleResources.contains(resource)) {
				node.setChecked(true);
			}
			resultTreeNodes.add(node);
		}
		return resultTreeNodes;
	}
	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrUpdate(ResourceDTO resource) {
		if (resource.getResourceId() != null) {
			ResourceDTO dbResource = find(resource.getResourceId());
			dbResource.setUpdateTime(new Date());
			dbResource.setName(resource.getName());
			dbResource.setSourceKey(resource.getSourceKey());
			dbResource.setType(resource.getType());
			dbResource.setSourceUrl(resource.getSourceUrl());
			dbResource.setLevel(resource.getLevel());
			dbResource.setSort(resource.getSort());
			dbResource.setIsHide(resource.getIsHide());
			dbResource.setIcon(resource.getIcon());
			dbResource.setDescription(resource.getDescription());
			dbResource.setUpdateTime(new Date());
			dbResource.setParentId(resource.getParentId());
			resourceDao.insertOrUpdate(dbResource);
		} else {
			resource.setCreateTime(new Date());
			resource.setUpdateTime(new Date());
			resourceDao.insertOrUpdate(resource);
		}

	}

	@Override
	public ResourceDTO find(Integer id) {
		return resourceDao.selectByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdate(Resource resource) {
		// TODO Auto-generated method stub

	}

	@Override
	public PageInfo<ResourceDTO> findAll(PageRequest pageRequest) {
		int pageNo = pageRequest.getPageNumber();
		int offset = pageRequest.getPageSize();
		offset = (pageNo) * offset;
		int totalPages = resourceDao.findTotalCount();
		List<ResourceDTO> users = resourceDao.findAllWithParams(offset, pageRequest.getPageSize());
		PageInfo<ResourceDTO> page = new PageInfo<>();
		page.setContent(users);
		page.setNumber(offset);
		page.setTotalPages(
				totalPages == 0 ? 1 : (int) Math.ceil((double) totalPages / (double) pageRequest.getPageSize()));
		page.setPages(totalPages);
		return page;
	}

	@Override
	public List<ResourceDTO> findAll() {
		return resourceDao.findAll();
	}

	@Override
	public List<ResourceDTO> findAllForShiro() {
		return resourceDao.findAllForShiro();
	}

}
