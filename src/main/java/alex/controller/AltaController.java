package alex.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import alex.entity.Equipaje;
import alex.entity.Equipaje_vuelo_pasajero;
import alex.entity.Facturacion;
import alex.entity.Pasajero;
import alex.entity.Vuelo;
import alex.entity.Vuelo_pasajero;
import alex.services.EquipajeService;
import alex.services.Equipaje_vuelo_pasajeroService;
import alex.services.FacturacionService;
import alex.services.PasajeroService;
import alex.services.VueloService;
import alex.services.Vuelo_pasajeroService;

@Controller
@Scope("session")
public class AltaController {
	
	@Autowired
	private Vuelo_pasajeroService serviceVueloPasajero;
	@Autowired
	private PasajeroService servicePasajero;
	@Autowired
	private Equipaje_vuelo_pasajeroService equi_vuelo_service;
    @Autowired
    private VueloService serviceVuelo;
    @Autowired
    private FacturacionService serviceFacturacion;
    
	@RequestMapping("altaVuelo")
	public String showAltaVuelo(ModelMap model, HttpServletRequest request) {
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
		
		List<Vuelo> misVuelos = serviceVuelo.getVuelos();
		model.addAttribute("vuelos", misVuelos);
		
		return "alta";}else{
			
			return "sesionExpiro";
			
		}
	}
	
	@RequestMapping(value ="altaPaso2", method = RequestMethod.GET)
	public String showAltaPaso2(@RequestParam("nomApel") String nomApel,@RequestParam("dni") String dni 
			,@RequestParam("edad")String edad,@RequestParam("vuelo_elegido") String id_vuelo,@RequestParam("equipaje") String equipaje,
			@RequestParam("peso") String peso, ModelMap model, HttpServletRequest request) {
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
		
		int dni_int = Integer.parseInt(dni);
		
		Pasajero miPasajero = new Pasajero();//***********
		Vuelo_pasajero miVueloPasajero = new Vuelo_pasajero();
		Equipaje_vuelo_pasajero miEquiVueloPasajero = new Equipaje_vuelo_pasajero();
		
		List<Pasajero> misPasajeros = servicePasajero.getPasajeros();
		
		int id_pasajero_top = 0;
		
		for(Pasajero p: misPasajeros){
			
			if(p.getId()>id_pasajero_top){
				
				id_pasajero_top = p.getId();
				
			}
			
		}//*******************
		miPasajero.setDni(dni_int);
		int edad_int = Integer.parseInt(edad);
		miPasajero.setEdad(edad_int);
		miPasajero.setId(id_pasajero_top+1);
		miPasajero.setNombre(nomApel);///***********************
		
		servicePasajero.create(miPasajero);
		
		
		
		miVueloPasajero.setId_pasajero(miPasajero.getId());
		int id_vuelo_int = Integer.parseInt(id_vuelo);
		miVueloPasajero.setId_vuelo(id_vuelo_int);
		miVueloPasajero.setPeso_total_equipaje(0);//*************
		
		serviceVueloPasajero.create(miVueloPasajero);
		
		double peso_double = Double.parseDouble(peso);
		miEquiVueloPasajero.setDescripcion(equipaje);//****************
		miEquiVueloPasajero.setId_pasajero(miPasajero.getId());
		miEquiVueloPasajero.setId_vuelo(id_vuelo_int);
		miEquiVueloPasajero.setPeso(peso_double);
		
		int id_equipaje = 0;
		List<Equipaje_vuelo_pasajero> misEquipajes = equi_vuelo_service.getEquipajes();
		
		for(Equipaje_vuelo_pasajero e: misEquipajes){
			
			if(e.getId()>id_equipaje){
				
				id_equipaje = e.getId();
	     		}
		
     		}
	
		miEquiVueloPasajero.setId(id_equipaje+1);	
		
		equi_vuelo_service.createEquiVueloPasajero(miEquiVueloPasajero);
	    
		Vuelo miVuelo = serviceVuelo.getVuelo(id_vuelo_int);
		
		model.addAttribute("pasajero", miPasajero);
		model.addAttribute("vuelo", miVuelo);
		model.addAttribute("equipajeVueloPasajero", miEquiVueloPasajero);
		model.addAttribute("vueloPasajero", miVueloPasajero);
		
		return "altaPaso2";}else{
			
			return "sesionExpiro";
			
		}
	}

	@RequestMapping(value ="cancelar_facturacion", method = RequestMethod.GET)
    public String cancelarFacturacion(@RequestParam("idPasajero") int idPasajero, @RequestParam("idVueloPasajero") int idVueloPasajero,
    		@RequestParam("idEquiVueloPasajero")int idEquiVueloPasajero, 
    		@RequestParam("idVuelo") int idVuelo, HttpServletRequest request){
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
		servicePasajero.deleteById(idPasajero);
		serviceVueloPasajero.deleteVueloPasajeroByIDPasajero(idVuelo, idVueloPasajero);
		equi_vuelo_service.deleteEquipajeByID(idEquiVueloPasajero);
		
		
		return "panel";}else{
			
			return "sesionExpiro";
			
		}
	}
	
	@RequestMapping("facturacion")
	public String facturacion(@RequestParam("nombre") String nombre, @RequestParam("origen") String origen,
			@RequestParam("destino") String destino, @RequestParam("costo") String costo,
			@RequestParam("tarjeta") String tarjeta,@RequestParam("numTarjeta") String numTarjeta,
			@RequestParam("numSeguridad") String numSeguridad,ModelMap model, HttpServletRequest request){
		
		if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
	
		List<Facturacion> misFacturaciones = serviceFacturacion.getFacturaciones();
		int ultima_id = 1;
		
		for(Facturacion f: misFacturaciones){
			
			if(f.getId()>ultima_id){
				
				ultima_id = f.getId();
				
			}
			
		}//**fin del for
		
		int costo_int = Integer.parseInt(costo);
		//int numTarjeta_int = Integer.parseInt(numTarjeta);
		int numSeguridad_int = Integer.parseInt(numSeguridad);
		String origen_destino = "Origen: "+origen+" Destino: "+ destino;
		
		
		Facturacion miFacturacion = new Facturacion();//******************
		miFacturacion.setId(ultima_id+1);
		miFacturacion.setCosto(costo_int);
		miFacturacion.setDestino(origen_destino);
		miFacturacion.setMedio_pago(tarjeta);
		miFacturacion.setNombre_yapel(nombre);
		miFacturacion.setNum_seguridad(numSeguridad_int);
		miFacturacion.setNumero_tarjeta(numTarjeta);
		 
		serviceFacturacion.createFacturacion(miFacturacion);
		
		model.addAttribute("Exito","Facturacion exitosa");
		
		return "panel";}else{
			
			return "sesionExpiro";
			
		}
	}
}
