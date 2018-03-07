package com.convergence.web.admin.system;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convergence.domain.ResourceDTO;
import com.convergence.domain.vo.ZtreeView;
import com.convergence.service.ResourceService;
import com.convergence.support.common.Result;
import com.convergence.web.BaseController;

@Controller
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController {
    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/tree/{resourceId}")
    @ResponseBody
    public List<ZtreeView> tree(@PathVariable Integer resourceId) {
        List<ZtreeView> list = resourceService.tree(resourceId);
        return list;
    }

    @RequestMapping("/index")
    public String index() {
        return "admin/resource/index";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Page<ResourceDTO> list() {
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        List<ResourceDTO> list = resourceService.findAll();
        map.put("list", list);
        return "admin/resource/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {

        return "admin/resource/form";
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    @ResponseBody
    public Result edit(ResourceDTO resource, ModelMap map) {
        return Result.success();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@PathVariable Integer id, ModelMap map) {
        return Result.success();
    }
}
