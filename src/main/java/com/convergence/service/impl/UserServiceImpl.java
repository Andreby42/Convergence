package com.convergence.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.convergence.dao.UserDao;
import com.convergence.domain.UserDTO;
import com.convergence.service.UserService;
import com.convergence.support.MD5Utils;
import com.convergence.support.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

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
	public void grant(Integer id, String[] roleIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		userDao.deleteByPrimaryKey(id);
	}

	@Override
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
	public void updatePwd(UserDTO principal, String oldPassword, String password1, String password2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateDeleteStatus(Integer id) {
		UserDTO user = userDao.selectByPrimaryKey(id);
		if (!user.getUserName().equals("admin")) {
			user.setStatus("1");
			user.setUpdateTime(new Date());
			userDao.updateByPrimaryKey(user);
		}
	}

}
