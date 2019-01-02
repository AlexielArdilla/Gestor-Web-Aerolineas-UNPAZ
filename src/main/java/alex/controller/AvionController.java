package alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import alex.entity.Avion;
import alex.entity.Ciudad;
import alex.entity.Vuelo;
import alex.services.AvionService;
import alex.services.CiudadService;
import alex.services.VueloService;

@Controller
public class AvionController {

	@Autowired
	private AvionService service;
	@Autowired
	private VueloService serviceVuelo;

	@RequestMapping("registrationPage")
	public String showRegistrationPage() {
		return "avionReg_";
	}
	
	
	
	
	@RequestMapping("panel")
	public String showPanelPage() {
		return "panel";
	}

	@RequestMapping(value = "registerAvion", method = RequestMethod.POST)
	public String registerAvion(@ModelAttribute("avion") Avion avion, ModelMap model) {

		int result = service.save(avion);
		model.addAttribute("result", "Avion Created With Id: " + result);

		return "avionReg_";
	}

	@RequestMapping("getAviones")
	public String getAviones(ModelMap model) {
		List<Avion> aviones = service.getAviones();
		model.addAttribute("aviones", aviones);
		return "displayAviones_";
	}

	@RequestMapping("validateId")
	public @ResponseBody String validateId(@RequestParam("id") int id) {
		Avion avion = service.getAvion(id);
		String msg = "";

		if (avion != null) {
			msg = id + " already exists";
		}
		return msg;

	}

	public AvionService getService() {
		return service;
	}

	public void setService(AvionService service) {
		this.service = service;
	}

}
