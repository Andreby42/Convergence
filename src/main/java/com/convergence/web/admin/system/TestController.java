package com.convergence.web.admin.system;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.convergence.domain.UserDTO;
import com.convergence.mq.rabbit.TestRabbitMq;
import com.convergence.service.UserService;
import com.convergence.support.PageInfo;
import com.convergence.web.BaseController;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
	@Autowired
	private UserService userService;
	@Resource
	private TestRabbitMq testRabbitMq;
	
	@RequestMapping(value = { "/index" })
	public String index(ModelMap modelMap) {
		PageInfo<UserDTO> page = userService.findAll(getPageRequest());
		modelMap.put("pageInfo", page);
		return "user/index";
	}
//	@RequestMapping(value = { "/1" })
	public void testMq() throws InterruptedException{
		for (int i=0 ;i<100000; i++) {
			TimeUnit.MILLISECONDS.sleep(1);
			testRabbitMq.sendMsgTest();
		}
	}

}
