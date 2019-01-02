package alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import alex.entity.Vuelo;
import alex.services.VueloService;

@Controller
public class AltaController {
	
	@Autowired
	private VueloService serviceVuelo;

	
	@RequestMapping("altaVuelo")
	public String showAltaVuelo(ModelMap model) {
		
		List<Vuelo> misVuelos = serviceVuelo.getVuelos();
		model.addAttribute("vuelos", misVuelos);
		
		return "alta";
	}
	
	@RequestMapping(value ="altaPaso2", method = RequestMethod.GET)
	public String showAltaPaso2(@RequestParam("nomApel") String nomApel,@RequestParam("dni") String dni 
			,@RequestParam("edad")String edad,@RequestParam("vuelo_elegido") String id_vuelo,@RequestParam("equipaje") String equipaje,
			@RequestParam("peso") String peso, ModelMap model) {
		

		//TODO Manejar esto!!!
		
		
		
		return "altaPaso2";
	}


}
