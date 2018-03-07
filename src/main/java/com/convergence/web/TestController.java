package com.convergence.web;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.convergence.domain.AtomDTO;
import com.convergence.service.AtomService;

@RestController
@RequestMapping("/test")
public class TestController {

    // @Resource
    // private MgAtomService mgAtomService;
    @Resource
    private AtomService atomService;

    @RequestMapping(value = "/mg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testMg() {
        AtomDTO atomDTO = atomService.selectByPrimaryKey(99);
        // mgAtomService.insert(atomDTO);
        // AtomDTO selectOne = mgAtomService.selectOne(99);
        return JSON.toJSONString(atomDTO);
    }
}
