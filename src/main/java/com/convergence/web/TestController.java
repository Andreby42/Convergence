package com.convergence.web;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.convergence.config.ProtoBufMediaType;
import com.convergence.domain.AtomDTO;
import com.convergence.protobuf.Atom;
import com.convergence.protobuf.Atom.AtomMsg.Builder;
import com.convergence.service.AtomService;
import com.convergence.service.mongo.MgAtomService;

@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    private MgAtomService mgAtomService;
    @Resource
    private AtomService atomService;

    @RequestMapping(value = "/mg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testMg() {
        AtomDTO atomDTO = atomService.selectByPrimaryKey(99);
        // mgAtomService.in(atomDTO);
        // AtomDTO selectOne = mgAtomService.selectOne(99);
        return JSON.toJSONString(atomDTO);
    }

    @RequestMapping(value = "/pmg", produces = ProtoBufMediaType.APPLICATION_PROTOBUF_VALUE)
    @ResponseBody
    public Builder testProtoMg() {
        AtomDTO atomDTO = atomService.selectByPrimaryKey(1);
        // mgAtomService.in(atomDTO);
        // AtomDTO selectOne = mgAtomService.selectOne(99);
        Atom.AtomMsg.Builder builder = Atom.AtomMsg.newBuilder();
        builder.setAddress("1232");
        return builder;
    }
}
