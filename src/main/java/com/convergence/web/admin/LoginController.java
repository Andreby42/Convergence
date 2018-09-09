package com.convergence.web.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.convergence.web.BaseController;

@Controller 
public class LoginController extends BaseController {
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap model) {
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
			return redirect("/index");
		} catch (AuthenticationException e) {
			model.put("message", e.getMessage());
		}
		return "login";
	}
	   @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	    public String logout() {
	        Subject subject = SecurityUtils.getSubject();
	        subject.logout();
	        return redirect("login");
	    }
}
