package alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import alex.entity.Vuelo;
import alex.services.VueloService;

@Controller
public class VueloController {
	
	@Autowired
	VueloService service;
	
	@RequestMapping("getVuelos")
	public String verVuelos(ModelMap model){
		
		List<Vuelo> vuelos = service.getVuelos();
		model.addAttribute("vuelos", vuelos);
		
		return "displayVuelos";
	}
	
}
