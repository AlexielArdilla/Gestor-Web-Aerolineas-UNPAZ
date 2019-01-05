package alex.dao;

import java.util.List;

import alex.entity.Equipaje_vuelo_pasajero;

public interface Equipaje_vuelo_pasajeroDAO {

	
	List<Equipaje_vuelo_pasajero> getEquipajes();
	
	int deleteEquipajeByID(int id);
	
	int createEquiVueloPasajero(Equipaje_vuelo_pasajero equipaje_vuelo_pas);
	
}
