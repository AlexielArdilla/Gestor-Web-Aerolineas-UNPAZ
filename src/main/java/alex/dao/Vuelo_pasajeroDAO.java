package alex.dao;

import java.util.List;

import alex.entity.Avion;
import alex.entity.Vuelo_pasajero;

public interface Vuelo_pasajeroDAO {

	int create(Vuelo_pasajero v_pasajero);

	List<Vuelo_pasajero> findVuelos_pasajero();

	Vuelo_pasajero findAVuelo_pasajeroByIDPasajero(int id);
	
	int deleteVueloPasajeroByIDPasajero(int id_vuelo, int id_pasajero);
	
}
