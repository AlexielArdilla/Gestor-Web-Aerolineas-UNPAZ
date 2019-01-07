package alex.controller;

import alex.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import alex.services.BreakService;

@Controller
public class BreakController {

	@Autowired
	BreakService service;
	
	@RequestMapping("pedir_break")
	public String pedirBreak(ModelMap model){
		
		User miUser = new User(); //aqui va el user de la sesion 
		miUser.setId(10);
		miUser.setName("Ale");
		miUser.setPassword("qwerty");
		
		service.createComienzoBreak(miUser);
		
		return "break";
		
	}
	
	@RequestMapping("terminar_Break")
	public String mostrarBaja(ModelMap model){
		
		User miUser = new User(); //aqui va el user de la sesion 
		miUser.setId(10);
		miUser.setName("Ale");
		miUser.setPassword("qwerty");
		
		service.createFinalBreak(miUser);
		
		return "panel";
		
	}
	
}
