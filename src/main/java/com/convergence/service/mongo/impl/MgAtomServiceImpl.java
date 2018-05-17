package com.convergence.service.mongo.impl;

import com.convergence.domain.AtomDTO;
import com.convergence.service.mongo.MgAtomService;

// @Service
public class MgAtomServiceImpl implements MgAtomService {

	@Override
	public void insert(AtomDTO atomDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AtomDTO selectOne(int atomid) {
		// TODO Auto-generated method stub
		return null;
	}

/*     @Resource
    private AtomRespository atomRespository;

    @Override
    public void insert(AtomDTO atomDTO) {
        atomRespository.insert(atomDTO);
    }

    @Override
    public AtomDTO selectOne(int atomid) {
        return atomRespository.findOne(atomid);
    }
*/
}
