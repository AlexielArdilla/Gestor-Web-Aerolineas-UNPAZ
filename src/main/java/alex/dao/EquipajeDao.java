package alex.dao;

import java.util.List;

import alex.entity.Equipaje;



public interface EquipajeDao {

	List<Equipaje> findEquipajes();

	Equipaje findEquipaje(Integer id);
	
	int deleteById(int id);
	
}
