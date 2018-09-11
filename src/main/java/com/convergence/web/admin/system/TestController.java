package com.convergence.web.admin.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.convergence.domain.UserDTO;
import com.convergence.service.RoleService;
import com.convergence.service.UserService;
import com.convergence.support.PageInfo;
import com.convergence.web.BaseController;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/index" })
	public String index(ModelMap modelMap) {
		PageInfo<UserDTO> page = userService.findAll(getPageRequest());
		modelMap.put("pageInfo", page);
		return "user/index";
	}
}
