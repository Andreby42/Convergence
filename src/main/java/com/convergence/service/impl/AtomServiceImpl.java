package com.convergence.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.convergence.dao.AtomDao;
import com.convergence.domain.AtomDTO;
import com.convergence.service.AtomService;

@Service
public class AtomServiceImpl implements AtomService {
    @Resource
    private AtomDao atomDao;

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer atomId) {
        return atomDao.deleteByPrimaryKey(atomId);
    }

    @Override
    @Transactional
    public int insert(AtomDTO record) {
        return atomDao.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(AtomDTO record) {
        return atomDao.insertSelective(record);
    }

    @Override
    @Transactional(readOnly = true)
    public AtomDTO selectByPrimaryKey(Integer atomId) {
        return atomDao.selectByPrimaryKey(atomId);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(AtomDTO record) {
        return atomDao.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(AtomDTO record) {
        return atomDao.updateByPrimaryKey(record);
    }

}
