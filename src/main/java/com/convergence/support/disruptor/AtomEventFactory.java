package com.convergence.support.disruptor;

import com.lmax.disruptor.EventFactory;
/**
 * 一个 Event 实例实际上被用作一个“数据槽”， 发布者发布前
 * 先从 RingBuffer 获得一个 Event 的实例， 然后往 Event
 * 实例中填充数据，之后再发布到 RingBuffer 中，
 * 之后由 Consumer 获得该 Event 实例并从中读取数据。
 * @author andy
 *
 */
public class AtomEventFactory implements EventFactory<AtomEvent>{

	@Override
	public AtomEvent newInstance() {
		return new AtomEvent();
	}

}
