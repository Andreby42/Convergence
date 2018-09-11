package com.convergence.web.admin.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convergence.domain.RoleDTO;
import com.convergence.domain.UserDTO;
import com.convergence.service.RoleService;
import com.convergence.service.UserService;
import com.convergence.support.JsonResult;
import com.convergence.support.PageInfo;
import com.convergence.web.BaseController;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = { "/index" })
	public String index(ModelMap modelMap) {
		PageInfo<UserDTO> page = userService.findAll(getPageRequest());
		modelMap.put("pageInfo", page);
		return "user/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		return "user/addform";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap map) {
		UserDTO user = userService.find(id);
		map.put("user", user);
		return "user/form";
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	@ResponseBody
	public com.convergence.support.JsonResult edit(UserDTO user, ModelMap map) {
		try {
			userService.saveOrUpdate(user);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable String id, ModelMap map) {
		try {
			userService.UpdateDeleteStatus(Integer.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	@RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
	public String grant(@PathVariable Integer id, ModelMap map) {
		UserDTO user = userService.find(id);
		map.put("user", user);
		Set<RoleDTO> set = roleService.selectRolesByUserId(String.valueOf(id));
		List<Integer> roleIds = new ArrayList<Integer>();
		for (RoleDTO role : set) {
			roleIds.add(role.getRoleId());
		}
		map.put("roleIds", roleIds);

		List<RoleDTO> roles = roleService.findAll();
		map.put("roles", roles);
		return "user/grant";
	}

	@ResponseBody
	@RequestMapping(value = "/grant/{id}", method = RequestMethod.POST)
	public JsonResult grant(@PathVariable Integer id, String[] roleIds, ModelMap map) {
		try {
			userService.grant(id, roleIds);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	@RequestMapping(value = "/updatePwd", method = RequestMethod.GET)
	public String updatePwd() {
		return "user/updatePwd";
	}

	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult updatePwd(String oldPassword, String password1, String password2) {
		try {
			Subject subject = SecurityUtils.getSubject();
			Object principal = subject.getPrincipal();
			if (principal == null) {
				return JsonResult.failure("您尚未登录");
			}
			userService.updatePwd((UserDTO) principal, oldPassword, password1, password2);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
