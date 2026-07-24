package alex.dao;

import java.util.List;

import alex.entity.Vuelo;

public interface VueloDao {


	List<Vuelo> findVuelos();

	Vuelo findVuelo(Integer id);
	
	List<Vuelo> findVueloByDNI(int dni);
}
