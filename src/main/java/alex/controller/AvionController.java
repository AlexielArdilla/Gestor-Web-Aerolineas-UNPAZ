package alex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@Scope("session")
public class AvionController {

	@Autowired
	private AvionService service;
	@Autowired
	private VueloService serviceVuelo;

	@RequestMapping("panel")
	public String showPanelPage(HttpServletRequest request) {
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
			
			System.out.println("Entró en panel con sesion creada!!!");
		return "panel";
		
		}else{
			
			return "sesionExpiro";
			
		}
	}

	@RequestMapping(value = "registerAvion", method = RequestMethod.POST)
	public String registerAvion(@ModelAttribute("avion") Avion avion, ModelMap model, HttpServletRequest request) {

		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
			
		int result = service.save(avion);
		model.addAttribute("result", "Avion Created With Id: " + result);

		return "avionReg_";}else{
			
			return "sesionExpiro";
			
		}
	}

	@RequestMapping("getAviones")
	public String getAviones(ModelMap model, HttpServletRequest request) {
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
			
		List<Avion> aviones = service.getAviones();
		model.addAttribute("aviones", aviones);
		return "displayAviones_";
		
		}else{
			
			return "sesionExpiro";
			
		}
	}

	@RequestMapping("validateId")
	public @ResponseBody String validateId(@RequestParam("id") int id, HttpServletRequest request) {
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
		Avion avion = service.getAvion(id);
		String msg = "";

		if (avion != null) {
			msg = id + " already exists";
		}
		return msg;}else{
			
			
			return "sesionExpiro";
		}

	}

	public AvionService getService() {
		return service;
	}

	public void setService(AvionService service) {
		this.service = service;
	}

}
