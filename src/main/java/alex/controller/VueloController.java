package alex.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import alex.entity.Equipaje_vuelo_pasajero;
import alex.entity.Vuelo;
import alex.entity.Vuelo_pasajero;
import alex.services.Equipaje_vuelo_pasajeroService;
import alex.services.VueloService;
import alex.services.Vuelo_pasajeroService;

@Controller
public class VueloController {
	
	@Autowired
	VueloService service;
	@Autowired
	Vuelo_pasajeroService serviceVueloPasajero;
	@Autowired
	Equipaje_vuelo_pasajeroService serviceEquipajeVueloPasajero;
	
	@RequestMapping("getVuelos")
	public String verVuelos(ModelMap model){
		
		List<Vuelo> vuelos = service.getVuelos();
		model.addAttribute("vuelos", vuelos);
		
		return "displayVuelos";
	}
	
	@RequestMapping("getVuelosExdEquipaje")
	public String verVuelosExdEquipaje(ModelMap model){
		
		List<Vuelo> vuelos = service.getVuelos();
		model.addAttribute("vuelos", vuelos);
		
		List<Vuelo_pasajero> misVuelosPasajero = serviceVueloPasajero.findVuelos_pasajero();
		
		int max_cantidad_equipaje_KG = 100000;
		
		List<Equipaje_vuelo_pasajero> misEquiVueloPasajero = serviceEquipajeVueloPasajero.getEquipajes();
		double peso_cargaKG = 0;
		
		for(Vuelo_pasajero vuelo: misVuelosPasajero){
			
			for(Equipaje_vuelo_pasajero equipaje: misEquiVueloPasajero){
				
				if(vuelo.getId_vuelo()==equipaje.getId_vuelo()){
					
					peso_cargaKG+= equipaje.getPeso();
				
					if(peso_cargaKG<max_cantidad_equipaje_KG){
					
					vuelo.setPeso_total_equipaje(peso_cargaKG);
					
					}else{
						
						vuelo.setPeso_total_equipaje(99999999.9);
						vuelo.setExcedido(true);
						
					}//fin if else
					
				}//fin del if
				
				
			}//fin del for interno***
			peso_cargaKG =0;
			
		}
		
		for(Vuelo_pasajero v:misVuelosPasajero){
		
		serviceVueloPasajero.updatePesoTotalVuelopasajero(v);
		
		}
		
		model.addAttribute("vuelosPasajero", misVuelosPasajero);
		
		return "displayVuelosExedEquipaje";
	}
	
	
}
