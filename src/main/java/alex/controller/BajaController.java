package alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import alex.entity.Pasajero;
import alex.entity.Vuelo;
import alex.services.EquipajeService;
import alex.services.PasajeroService;
import alex.services.VueloService;

@Controller
public class BajaController {
	
	@Autowired
	PasajeroService servicePasajero;
	@Autowired
	EquipajeService serviceEquipaje;
	@Autowired
	VueloService serviceVuelo;
	
	@RequestMapping("mostrar_baja")
	public String mostrarBaja(ModelMap model){
		
		return "baja";
		
	}
	
	@RequestMapping("baja_reserva")
	public String mostrarBajaConDatos(@RequestParam("dni") String dni, ModelMap model){
		
		int dni_int = Integer.parseInt(dni);
		List<Vuelo> misVuelos = serviceVuelo.findVueloByDNI(dni_int);
		Pasajero miPasajero = servicePasajero.findByDNI(dni_int);
		
		model.addAttribute("vuelos", misVuelos);
		model.addAttribute("pasajero", miPasajero);
		
		return "bajaPaso2";
	}
	
	@RequestMapping(value = "eliminar_pasajero", method = RequestMethod.GET)
	public String eliminarVuelo(@RequestParam("pasajero_id") String pasajero_id,ModelMap model) {
		
		int id = Integer.parseInt(pasajero_id);
		
		int miPasajero = servicePasajero.deleteById(id);//ojo no se borró el equipaje!!!
		
		String exito = "Eliminado con exito";

		model.addAttribute("exito", exito);
		return "baja";
	}

}
