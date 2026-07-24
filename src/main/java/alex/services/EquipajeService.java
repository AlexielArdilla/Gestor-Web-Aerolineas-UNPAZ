package alex.services;

import java.util.List;

import alex.entity.Equipaje;

public interface EquipajeService {

	List<Equipaje> getEquipajes();

	Equipaje getEquipaje(Integer id);
	
	int deleteById(int id);
}
