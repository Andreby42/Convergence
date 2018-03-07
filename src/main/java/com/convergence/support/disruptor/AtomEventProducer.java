package com.convergence.support.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class AtomEventProducer {
    private RingBuffer<AtomEvent> ringBuffer;

    public AtomEventProducer(RingBuffer<AtomEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<AtomEvent, AtomModel> TRANSLATOR =
            new EventTranslatorOneArg<AtomEvent, AtomModel>() {
                @Override
                public void translateTo(AtomEvent event, long sequence, AtomModel value) {
                    event.setAtomModel(value);
                }

            };

    /**
     * 添加并发布消息
     * 
     * @param value
     */
    public void onData(AtomModel value) {
        ringBuffer.publishEvent(TRANSLATOR, value);
    }
}
