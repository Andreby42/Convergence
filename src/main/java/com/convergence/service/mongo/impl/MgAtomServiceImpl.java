package com.convergence.service.mongo.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.convergence.dao.AtomRespository;
import com.convergence.domain.AtomDTO;
import com.convergence.service.mongo.MgAtomService;

@Service
public class MgAtomServiceImpl implements MgAtomService {

	@Resource
	private AtomRespository atomRespository;

	@Override
	public void insert(AtomDTO atomDTO) {
		atomRespository.insert(atomDTO);
	}

	@Override
	public AtomDTO selectOne(int atomid) {
		return atomRespository.findOne(atomid);
	}

}
