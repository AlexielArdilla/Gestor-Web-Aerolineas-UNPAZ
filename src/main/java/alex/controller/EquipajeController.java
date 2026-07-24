package alex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import alex.entity.Equipaje;
import alex.entity.Equipaje_vuelo_pasajero;
import alex.services.EquipajeService;
import alex.services.Equipaje_vuelo_pasajeroService;
import alex.services.PasajeroService;

@Controller
@Scope("session")
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
	public String dameEquipajes(ModelMap model, HttpServletRequest request){
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
		
		List<Equipaje> misEquipajes = service.getEquipajes();
		int max_cantidad_equipaje_KG = 100;
		
		for(Equipaje equipaje: misEquipajes){
			
			if(equipaje.getPeso()>max_cantidad_equipaje_KG){
				
				equipaje.setExcedido(true);
				
			}else{
				
				equipaje.setExcedido(false);
				
			}
			
		}
		
		model.addAttribute("equipajes",misEquipajes);
		
		return "displayEquipajes"; 
		
		}else{
			
			return "sesionExpiro";
			
		}
	}
	
}
