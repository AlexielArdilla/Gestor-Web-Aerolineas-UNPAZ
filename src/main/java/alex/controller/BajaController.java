package alex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import alex.entity.Equipaje_vuelo_pasajero;
import alex.entity.Pasajero;
import alex.entity.Vuelo;
import alex.services.EquipajeService;
import alex.services.Equipaje_vuelo_pasajeroService;
import alex.services.PasajeroService;
import alex.services.VueloService;
import alex.services.Vuelo_pasajeroService;

@Controller
@Scope("session")
public class BajaController {
	
	@Autowired
	PasajeroService servicePasajero;
	@Autowired
	EquipajeService serviceEquipaje;
	@Autowired
	VueloService serviceVuelo;
	@Autowired
	Equipaje_vuelo_pasajeroService serviceEquiVueloPasajero;
	@Autowired
	Vuelo_pasajeroService serviceVueloPasajero;
	
	@RequestMapping("mostrar_baja")
	public String mostrarBaja(ModelMap model, HttpServletRequest request){
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
		return "baja";
		
		}else{
			
			return "sesionExpiro";
		}
		
	}
	
	@RequestMapping("baja_reserva")
	public String mostrarBajaConDatos(@RequestParam("dni") String dni, ModelMap model, HttpServletRequest request){
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
			
		int dni_int = Integer.parseInt(dni);
		List<Vuelo> misVuelos = serviceVuelo.findVueloByDNI(dni_int);
		Pasajero miPasajero = servicePasajero.findByDNI(dni_int);
		
		model.addAttribute("vuelos", misVuelos);
		model.addAttribute("pasajero", miPasajero);
		
		return "bajaPaso2";
		
		}else{
			
			return "sesionExpiro";
			
		}
	}
	
	@RequestMapping(value = "eliminar_pasajero", method = RequestMethod.GET)
	public String eliminarVuelo(@RequestParam("pasajero_id") String pasajero_id,ModelMap model, HttpServletRequest request) {
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
			
		int id_pasajero_int = Integer.parseInt(pasajero_id);
		
		servicePasajero.deleteById(id_pasajero_int);//Borra pasajero
		
		List<Equipaje_vuelo_pasajero> misEquiVueloPasajero = serviceEquiVueloPasajero.getEquipajes();
		
		for(Equipaje_vuelo_pasajero e: misEquiVueloPasajero){
			
			if(id_pasajero_int==e.getId_pasajero()){//**borra equipaje vuelo pasajero*****y  Vuelo pasajero*****
				
				serviceEquiVueloPasajero.deleteEquipajeByID(e.getId());
				serviceVueloPasajero.deleteVueloPasajeroByIDPasajero(e.getId_vuelo(), id_pasajero_int);
				//falta eliminar facturacion!!!
			}//**fin del if
			
		}//**fin del forEach
		
		
		
		
		String exito = "Eliminado con exito";

		model.addAttribute("exito", exito);
		return "baja";
		
		}else{
			
			return "sesionExpiro";
			
		}
	}

}
