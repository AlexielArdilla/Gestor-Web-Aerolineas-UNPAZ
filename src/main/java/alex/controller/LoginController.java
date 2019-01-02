package alex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import alex.entity.User;
import alex.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String showPanelPage(@ModelAttribute("user") User user, ModelMap model) {
		
		return "panel";
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	
}
