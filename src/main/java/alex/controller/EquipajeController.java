package alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import alex.entity.Equipaje;
import alex.entity.Equipaje_vuelo_pasajero;
import alex.services.EquipajeService;
import alex.services.Equipaje_vuelo_pasajeroService;
import alex.services.PasajeroService;

@Controller
public class EquipajeController {

	@Autowired
	EquipajeService service;
	@Autowired
	PasajeroService servicePasajero;
	

	public EquipajeService getService() {
		return service;
	}

	public void setService(EquipajeService service) {
		this.service = service;
	}
	
	@RequestMapping("getEquipajes")
	public String dameEquipajes(ModelMap model){
		
		List<Equipaje> misEquipajes = service.getEquipajes();
		model.addAttribute("equipajes",misEquipajes);
		
		return "displayEquipajes"; 
	}
	
}
