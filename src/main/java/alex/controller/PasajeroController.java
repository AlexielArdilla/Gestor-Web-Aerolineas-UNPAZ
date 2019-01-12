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

import alex.entity.Pasajero;
import alex.entity.Vuelo;
import alex.services.PasajeroService;
import alex.services.VueloService;

@Controller
@Scope("session")
public class PasajeroController {

	@Autowired
	PasajeroService service;
	@Autowired
	VueloService serviceVuelo;
	
	@RequestMapping(value= "byDni", method = RequestMethod.GET)
	public String showPasajeroDNI(@RequestParam("dniPasajero") String dni, ModelMap model, HttpServletRequest request){
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
		
		int dni_int = Integer.parseInt(dni);
		List<Vuelo> misVuelos = serviceVuelo.findVueloByDNI(dni_int);
		Pasajero miPasajero = service.findByDNI(dni_int);
		
		model.addAttribute("vuelos", misVuelos);
		model.addAttribute("pasajero", miPasajero);
		
		return "pasajeroPorDNI";
		
		}else{
			
			return "sesionExpiro";
			
		}
	}
	
}
