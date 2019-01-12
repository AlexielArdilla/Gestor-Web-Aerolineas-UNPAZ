package alex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import alex.entity.Avion;
import alex.entity.Ciudad;
import alex.services.CiudadService;

@Controller
@Scope("session")
public class CiudadController {
	
	@Autowired
	private CiudadService service;

	
	@RequestMapping("getCiudades")
	public String getCiudades(ModelMap model, HttpServletRequest request) {
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
			
		List<Ciudad> ciudades = service.getCiudades();
		model.addAttribute("ciudades", ciudades);
		return "displayCiudades";
		
		}else{
			
			return "sesionExpiro";
			
		}
	}
	
	
	public CiudadService getService() {
		return service;
	}

	public void setService(CiudadService service) {
		this.service = service;
	}
	
	

}
