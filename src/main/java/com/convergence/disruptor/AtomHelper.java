package com.convergence.disruptor;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

@Component
@Scope("singleton")
public class AtomHelper {

	/**
	 * ringBuffer的容量，必须是2的N次方
	 */
	private static final int BUFFER_SIZE = 1024 * 1024;

	private Disruptor<AtomEvent> disruptor = null;
	private AtomEventProducer producer = null;

	@SuppressWarnings("unchecked")
	public AtomHelper() {
		disruptor = new Disruptor<AtomEvent>(new AtomEventFactory(), BUFFER_SIZE, DaemonThreadFactory.INSTANCE,
				ProducerType.SINGLE, new YieldingWaitStrategy());
//		disruptor.handleEventsWith(new AtomEventHandler());
		disruptor.handleEventsWithWorkerPool(new AtomEventHandler("woker-1"),new AtomEventHandler("woker-2"),new AtomEventHandler("woker-3"));
		// disruptor.handleEventsWith(new MyEventHandler()).then(new
		// MyEventHandler()); //Pipeline
		RingBuffer<AtomEvent> ringBuffer = disruptor.start();

		producer = new AtomEventProducer(ringBuffer);
		// for (long i = 0; i < 10; i++) {
		// producer.onData(i);
		// Thread.sleep(1000);// wait for task execute....
		// }
		//
//		 disruptor.shutdown();
	}

	public void onData(AtomModel value) {
		producer.onData(value);
	}

	public void shutdown() {
		disruptor.shutdown();
	}
}
