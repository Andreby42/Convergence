package com.convergence.web.admin.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by SPPan
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController {

    @RequestMapping("/no")
    public String no() {
        return "privilege/no";
    }
}
