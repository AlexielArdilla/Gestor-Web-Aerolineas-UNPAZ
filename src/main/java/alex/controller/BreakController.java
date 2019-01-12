package alex.controller;

import alex.entity.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import alex.services.BreakService;

@Controller
@Scope("session")
public class BreakController {

	@Autowired
	BreakService service;
	
	@RequestMapping("pedir_break")
	public String pedirBreak(ModelMap model, HttpServletRequest request){
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
		
		User miUser = new User(); //aqui va el user de la sesion 
		miUser.setId(10);
		miUser.setName("Ale");
		miUser.setPassword("qwerty");
		
		service.createComienzoBreak(miUser);
		
		return "break";}else{
			
			return "sesionExpiro";
		}
		
	}
	
	@RequestMapping("terminar_Break")
	public String mostrarBaja(ModelMap model, HttpServletRequest request){
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
			
		User miUser = new User(); //aqui va el user de la sesion 
		miUser.setId(10);
		miUser.setName("Ale");
		miUser.setPassword("qwerty");
		
		service.createFinalBreak(miUser);
		
		return "panel";}else{
			
			return "sesionExpiro";
			
		}
		
	}
	
}
