package alex.controller;

import java.util.List;

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
	public String showPanelPage(@ModelAttribute("user") String user,@ModelAttribute("password") String password, ModelMap model) {
		
		List<User> misUsers = service.getUsers();
		
		for(User m: misUsers){
			
			if(user.equals(m.getName())&&password.equals(m.getPassword())){
				
				return "panel";
			}
			
		}
	   	
			model.addAttribute("user", user);
			model.addAttribute("password", password);
			
		  return "index2";	
		
		
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	
}
