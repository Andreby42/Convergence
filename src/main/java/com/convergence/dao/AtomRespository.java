package com.convergence.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.convergence.domain.AtomDTO;

/**
 * mongodb dao层
 * 
 * @author andy
 *
 */
@Repository
public interface AtomRespository extends MongoRepository<AtomDTO, Integer> {

}
