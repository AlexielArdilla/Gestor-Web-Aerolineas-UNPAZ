package alex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.dao.PasajeroDao;
import alex.entity.Pasajero;

@Service
public class PasajeroServiceImpl implements PasajeroService{

	@Autowired
	PasajeroDao dao;
	
	
	public PasajeroDao getDao() {
		return dao;
	}

	public void setDao(PasajeroDao dao) {
		this.dao = dao;
	}

	@Override
	public int create(Pasajero pasajero) {
		
		return dao.create(pasajero);
		
	}

	@Override
	public Pasajero findByDNI(int dni) {
		
		return dao.findByDNI(dni);
	}

	@Override
	public int deleteById(int id) {
		
		return dao.deleteById(id);
		
	}

	@Override
	public List<Pasajero> getPasajeros() {
		
		return dao.getPasajeros();
	}

}
