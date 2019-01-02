package alex.dao;

import alex.entity.Pasajero;

public interface PasajeroDao {

	int create(Pasajero pasajero);
	
	Pasajero findByDNI(int dni);
	
	int deleteById(int id);
}
