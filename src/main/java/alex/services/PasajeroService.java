package alex.services;

import java.util.List;

import alex.entity.Pasajero;

public interface PasajeroService {

	 int create(Pasajero pasajero);
	 
	 Pasajero findByDNI(int dni);
	 
	 int deleteById(int id);
	 
	 List<Pasajero> getPasajeros();
}
