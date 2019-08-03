package com.convergence.protobuf;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.springframework.stereotype.Component;

import com.convergence.dao.AtomDao;
import com.convergence.domain.AtomDTO;

@Component
public class TestProtoBuf {
    @Resource
    private AtomDao atomDao;

//    @PostConstruct
    public void test() throws IllegalAccessException, InvocationTargetException {
//        AtomDTO atom = atomDao.selectByPrimaryKey(1);
//        Atom.AtomMsg.Builder atomBuilder = Atom.AtomMsg.newBuilder();
//        BeanUtilsBean2.getInstance().copyProperties(atomBuilder, atom);
    }
}
