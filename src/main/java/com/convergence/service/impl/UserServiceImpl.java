package com.convergence.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.convergence.dao.UserDao;
import com.convergence.domain.UserDTO;
import com.convergence.service.UserService;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void grant(Integer id, String[] roleIds) {
        // TODO Auto-generated method stub

    }

}
