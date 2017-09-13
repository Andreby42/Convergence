package com.convergence.service.mongo;

import com.convergence.domain.AtomDTO;

public interface MgAtomService {

	void insert(AtomDTO atomDTO);
	
	AtomDTO selectOne(int atomid);
}
