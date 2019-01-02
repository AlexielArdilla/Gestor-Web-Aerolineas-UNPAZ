package alex.services;

import alex.entity.Pasajero;

public interface PasajeroService {

	 int create(Pasajero pasajero);
	 
	 Pasajero findByDNI(int dni);
	 
	 int deleteById(int id);
}
