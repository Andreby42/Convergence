package com.convergence.support.disruptor;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.convergence.domain.AtomDTO;
import com.convergence.service.AtomService;

/**
 * 测试disruptor demo
 * 
 * @author andy
 *
 */
@Component
public class TestDisruptor {
    private static final Logger logger = LoggerFactory.getLogger(TestDisruptor.class);
    @Resource
    private AtomService atomService;
    // @Resource
    // private AtomHelper atomHelper;

    // @PostConstruct
    public void testDis() {

        for (int i = 0; i < 100000; i++) {
            AtomDTO at = new AtomDTO();
            AtomModel atomModel = new AtomModel();
            atomModel.setAtomDTO(at);
            atomModel.setAtomService(atomService);
            // atomHelper.onData(atomModel);
        }
    }
}
