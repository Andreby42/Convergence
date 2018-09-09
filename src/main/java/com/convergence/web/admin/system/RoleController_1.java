package com.convergence.web.admin.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convergence.domain.RoleDTO;
import com.convergence.service.ResourceService;
import com.convergence.service.RoleService;
import com.convergence.support.common.Result;
import com.convergence.web.BaseController;

@Controller
@RequestMapping("/admin/role")
public class RoleController_1 extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "admin/role/index";
    }

    @RequestMapping(value = {"/list"})
    @ResponseBody
    public Page<RoleDTO> list() {
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/role/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        return "admin/role/form";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    @ResponseBody
    public Result edit(RoleDTO role, ModelMap map) {
        return Result.success();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@PathVariable Integer id, ModelMap map) {
        return Result.success();
    }

    @RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
    public String grant(@PathVariable Integer id, ModelMap map) {
        return "admin/role/grant";
    }

    @RequestMapping(value = "/grant/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result grant(@PathVariable Integer id,
            @RequestParam(required = false) String[] resourceIds, ModelMap map) {
        try {
            roleService.grant(id, resourceIds);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
        return Result.success();
    }
}
