package alex.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import alex.entity.User;
import alex.services.UserService;

@Controller
@Scope("session")
public class LoginController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String showPanelPage(@ModelAttribute("user") String user,@ModelAttribute("password") String password,
			ModelMap model, HttpServletRequest request) {
		
		String password_a_MD5 = stringAMD5(password);
		
		List<User> misUsers = service.getUsers();
		
		for(User m: misUsers){
			
			if(user.equals(m.getName())&&password_a_MD5.equals(m.getPassword())){
				
				HttpSession session = request.getSession();
				   session.setMaxInactiveInterval(20*60);
				   request.getSession().setAttribute("user", m.getName());
				   
				return "panel";//**************************************
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
	
	public String stringAMD5(String password) {

		String hashtext = null;

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(password.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32
			// chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hashtext;
	}

}
