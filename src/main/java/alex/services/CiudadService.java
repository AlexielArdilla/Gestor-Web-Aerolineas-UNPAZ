package alex.services;

import java.util.List;

import alex.entity.Ciudad;


public interface CiudadService {

	List<Ciudad> getCiudades();

	Ciudad getCiudad(Integer id);
	
}
