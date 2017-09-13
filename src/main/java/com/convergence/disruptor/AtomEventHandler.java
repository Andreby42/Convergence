package com.convergence.disruptor;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.convergence.support.util.IdUtil;
import com.convergence.support.util.SnowFlake;
import com.convergence.support.util.UuidUtil;
import com.lmax.disruptor.WorkHandler;

public class AtomEventHandler implements WorkHandler<AtomEvent> {
	private static final Logger logger = LoggerFactory.getLogger(TestDisruptor.class);

	private String name;
	
	public AtomEventHandler(String name) {
		super();
		this.name = name;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void onEvent(AtomEvent event) throws Exception {
		logger.info("worker name 为{}",name);
		String nextId =  SnowFlake.getId();
//		Long nextId = Sequence.nextId();
		String nextId1 = UuidUtil.getNUUID(6);
		String id= nextId+nextId1;
		logger.info(Thread.currentThread().getName() + Thread.currentThread().getId() + "本次执行插入开始 id为{}",
				id);
		event.getAtomModel().getAtomService().insertSelective(event.getAtomModel().getAtomDTO());
	}

}
