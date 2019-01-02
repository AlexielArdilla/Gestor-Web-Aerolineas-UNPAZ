package alex.dao;

import java.util.List;

import alex.entity.Ciudad;

public interface CiudadDao {

	List<Ciudad> findCiudades();

	Ciudad findCiudad(Integer id);
	
}
