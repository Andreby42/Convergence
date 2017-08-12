package com.convergence.disruptor;

import java.io.Serializable;

import com.convergence.domain.AtomDTO;
import com.convergence.service.AtomService;

public class AtomModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AtomService atomService;
	private AtomDTO atomDTO;
	public AtomService getAtomService() {
		return atomService;
	}
	public void setAtomService(AtomService atomService) {
		this.atomService = atomService;
	}
	public AtomDTO getAtomDTO() {
		return atomDTO;
	}
	public void setAtomDTO(AtomDTO atomDTO) {
		this.atomDTO = atomDTO;
	}
	@Override
	public String toString() {
		return "AtomModel [atomService=" + atomService + ", atomDTO=" + atomDTO + "]";
	}
}
