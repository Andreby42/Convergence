package com.convergence;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
public class SwaggerTestController {


    @RequestMapping("/test")

    public String test(){
        return  "hello swagger" ;
    }
}
