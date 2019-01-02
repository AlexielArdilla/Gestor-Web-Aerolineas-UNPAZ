package alex.services;

import java.util.List;

import alex.entity.Vuelo;

public interface VueloService {
	
	List<Vuelo> getVuelos();

	Vuelo getVuelo(Integer id);
	
	List<Vuelo> findVueloByDNI(int dni);

}
