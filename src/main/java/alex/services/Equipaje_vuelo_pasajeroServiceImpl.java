package alex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.dao.Equipaje_vuelo_pasajeroDAO;
import alex.entity.Equipaje_vuelo_pasajero;

@Service
public class Equipaje_vuelo_pasajeroServiceImpl implements Equipaje_vuelo_pasajeroService {

	@Autowired
	Equipaje_vuelo_pasajeroDAO dao;
	
	public Equipaje_vuelo_pasajeroDAO getDao() {
		return dao;
	}

	public void setDao(Equipaje_vuelo_pasajeroDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Equipaje_vuelo_pasajero> getEquipajes() {
		
		return dao.getEquipajes();
	}

	@Override
	public int deleteEquipajeByID(int id) {
		
		return dao.deleteEquipajeByID(id);
	}

	@Override
	public int createEquiVueloPasajero(Equipaje_vuelo_pasajero equipaje_vuelo_pas) {
	
		return dao.createEquiVueloPasajero(equipaje_vuelo_pas);
	}

}
