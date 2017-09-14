package com.convergence.support.disruptor;

import java.io.Serializable;

import com.convergence.domain.AtomDTO;
import com.convergence.service.AtomService;

public class AtomEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AtomModel atomModel;
	public AtomModel getAtomModel() {
		return atomModel;
	}
	public void setAtomModel(AtomModel atomModel) {
		this.atomModel = atomModel;
	}
	@Override
	public String toString() {
		return "AtomEvent [atomModel=" + atomModel + "]";
	}
	
}
