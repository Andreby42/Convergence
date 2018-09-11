package com.convergence.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.convergence.dao.RoleDao;
import com.convergence.dao.UserDao;
import com.convergence.domain.UserDTO;
import com.convergence.domain.UserRoleDTO;
import com.convergence.service.UserService;
import com.convergence.support.MD5Utils;
import com.convergence.support.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private RoleDao roleDao;

	@Override
	@Transactional
	public int deleteByPrimaryKey(Integer userId) {
		return userDao.deleteByPrimaryKey(userId);
	}

	@Override
	@Transactional
	public int insert(UserDTO record) {
		return userDao.insert(record);
	}

	@Override
	@Transactional
	public int insertSelective(UserDTO record) {
		return userDao.insertSelective(record);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO selectByPrimaryKey(Integer userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(UserDTO record) {
		return userDao.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional
	public int updateByPrimaryKey(UserDTO record) {
		return userDao.updateByPrimaryKey(record);
	}

	@Override
	public UserDTO findByUserName(String username) {
		UserDTO findByUserName = userDao.findByUserName(username);
		return findByUserName;
	}

	@Override
	@Transactional
	public void grant(Integer id, String[] roleIds) {
		UserDTO user = find(id);
		Assert.notNull(user, "用户不存在");
		// Assert.state(!"admin".equals(user.getUserName()), "超级管理员用户不能修改管理角色");
		// 暴力點 先刪除 在插入
		userDao.deleteUserRoleByUserId(id);
		Set<UserRoleDTO> userRoles = new HashSet<UserRoleDTO>();
		if (roleIds != null) {
			for (int i = 0; i < roleIds.length; i++) {
				UserRoleDTO userRole = new UserRoleDTO();
				Integer rid = Integer.parseInt(roleIds[i]);
				userRole.setRoleId(rid);
				userRole.setUserId(id);
				userRoles.add(userRole);
			}
		}
		userDao.insertUserRoles(userRoles);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		userDao.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public PageInfo<UserDTO> findAll(PageRequest pageRequest) {
		int pageNo = pageRequest.getPageNumber();
		int offset = pageRequest.getPageSize();
		offset = (pageNo) * offset;
		int totalPages = userDao.findTotalCount();
		List<UserDTO> users = userDao.findAll(offset, pageRequest.getPageSize());
		PageInfo<UserDTO> page = new PageInfo<>();
		page.setContent(users);
		page.setNumber(offset);
		page.setTotalPages(
				totalPages == 0 ? 1 : (int) Math.ceil((double) totalPages / (double) pageRequest.getPageSize()));
		page.setPages(totalPages);
		return page;
	}

	@Override
	public UserDTO find(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public void saveOrUpdate(UserDTO user) {
		if (user.getUserId() != null) {
			UserDTO dbUser = userDao.selectByPrimaryKey(user.getUserId());
			dbUser.setNickName(user.getNickName());
			dbUser.setSex(user.getSex());
			dbUser.setBirthday(user.getBirthday());
			dbUser.setTelephone(user.getTelephone());
			dbUser.setEmail(user.getEmail());
			dbUser.setLocked(user.getLocked());
			dbUser.setDescription(user.getDescription());
			dbUser.setUpdateTime(new Date());
			dbUser.setStatus("0");
			userDao.insertOrUpdate(dbUser);
		} else {
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setStatus("0");
			user.setPassword(MD5Utils.md5("111111"));
			userDao.insertOrUpdate(user);
		}
	}

	@Override
	public void updatePwd(UserDTO user, String oldPassword, String password1, String password2) {
		Assert.notNull(user, "用户不能为空");
		Assert.notNull(oldPassword, "原始密码不能为空");
		Assert.notNull(password1, "新密码不能为空");
		Assert.notNull(password2, "重复密码不能为空");

		UserDTO dbUser = userDao.findByUserName(user.getUserName());
		Assert.notNull(dbUser, "用户不存在");

		Assert.isTrue(user.getPassword().equals(MD5Utils.md5(oldPassword)), "原始密码不正确");
		;
		Assert.isTrue(password1.equals(password2), "两次密码不一致");
		dbUser.setPassword(MD5Utils.md5(password1));
		userDao.updateByPrimaryKeySelective(dbUser);
	}

	@Override
	@Transactional
	public void UpdateDeleteStatus(Integer id) {
		UserDTO user = userDao.selectByPrimaryKey(id);
		if (!user.getUserName().equals("admin")) {
			user.setStatus("1");
			user.setUpdateTime(new Date());
			userDao.updateByPrimaryKey(user);
		}
	}

}
