package alex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.dao.Vuelo_pasajeroDAO;
import alex.entity.Vuelo_pasajero;

@Service
public class Vuelo_pasajeroServiceImpl implements Vuelo_pasajeroService{

	@Autowired
	Vuelo_pasajeroDAO dao;
	
	public Vuelo_pasajeroDAO getDao() {
		return dao;
	}

	public void setDao(Vuelo_pasajeroDAO dao) {
		this.dao = dao;
	}

	@Override
	public int create(Vuelo_pasajero v_pasajero) {
		
		return dao.create(v_pasajero);
	}

	@Override
	public List<Vuelo_pasajero> findVuelos_pasajero() {
		
		return dao.findVuelos_pasajero();
	}

	@Override
	public Vuelo_pasajero findAVuelo_pasajeroByIDPasajero(int id) {
		
		return dao.findAVuelo_pasajeroByIDPasajero(id);
	}

	@Override
	public int deleteVueloPasajeroByIDPasajero(int id_vuelo, int id_pasajero) {
		
		return dao.deleteVueloPasajeroByIDPasajero(id_vuelo, id_pasajero);
	}

	@Override
	public int updatePesoTotalVuelopasajero(Vuelo_pasajero vueloPasajero) {
		
		return dao.updatePesoTotalVuelopasajero(vueloPasajero);
	}

}
