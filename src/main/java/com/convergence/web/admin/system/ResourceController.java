package com.convergence.web.admin.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convergence.domain.ResourceDTO;
import com.convergence.domain.UserDTO;
import com.convergence.domain.model.ResourceModel;
import com.convergence.domain.vo.ZtreeView;
import com.convergence.service.ResourceService;
import com.convergence.support.JsonResult;
import com.convergence.support.PageInfo;
import com.convergence.web.BaseController;

@Controller
@RequestMapping("/resource")
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
	public String index(ModelMap map) {
		List<ResourceDTO> list = resourceService.findAll();
		map.put("list", list);
		return "resource/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		List<ResourceDTO> list = resourceService.findAll();
		map.put("list", list);
		return "resource/form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap map) {
		ResourceDTO resource = resourceService.find(id);
		map.put("resource", resource);

		List<ResourceDTO> list = resourceService.findAll();
		map.put("list", list);
		return "resource/form";
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(ResourceDTO resource, Integer parentId, ModelMap map) {
		try {
			if (parentId != null) {
				resource.setParentId(parentId);
			}
			resourceService.saveOrUpdate(resource);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id, ModelMap map) {
		try {
			resourceService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
