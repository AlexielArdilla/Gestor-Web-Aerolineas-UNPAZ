package alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import alex.entity.Avion;
import alex.entity.Ciudad;
import alex.services.CiudadService;

@Controller
public class CiudadController {
	
	@Autowired
	private CiudadService service;

	
	@RequestMapping("getCiudades")
	public String getCiudades(ModelMap model) {
		List<Ciudad> ciudades = service.getCiudades();
		model.addAttribute("ciudades", ciudades);
		return "displayCiudades";
	}
	
	
	public CiudadService getService() {
		return service;
	}

	public void setService(CiudadService service) {
		this.service = service;
	}
	
	

}
