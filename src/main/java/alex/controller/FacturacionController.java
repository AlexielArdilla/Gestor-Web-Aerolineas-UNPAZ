package alex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import alex.services.FacturacionService;
import alex.entity.Facturacion;;

@Controller
public class FacturacionController {
	
	@Autowired
	private FacturacionService service;
	
	@RequestMapping("facturacionPage")
	public String showRegistrationPage(ModelMap model) {
		
		List<Facturacion> misFactuaciones = service.getFacturaciones();
		model.addAttribute("facturaciones", misFactuaciones);
		
		return "facturacionLista";
	}
	
	@RequestMapping("eliminar_facturacion")
	public String eliminarFacturacion(@ModelAttribute("facturacion_id") String facturacion_id, ModelMap model){
		
		int id_facturacion = Integer.parseInt(facturacion_id);
		
		int r= service.deleteFacturacionByID(id_facturacion);
		
		if(r>0){
			
			model.addAttribute("exito", "Delete exitoso");
		}else{
			
			model.addAttribute("exito", "Error al borrar");
			
		}
		
		List<Facturacion> misFactuaciones = service.getFacturaciones();
		model.addAttribute("facturaciones", misFactuaciones);
		
		return "facturacionLista";
	}

}
