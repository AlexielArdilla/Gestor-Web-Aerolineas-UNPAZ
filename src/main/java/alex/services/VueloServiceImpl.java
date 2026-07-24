package alex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.dao.VueloDao;
import alex.entity.Vuelo;

@Service
public class VueloServiceImpl implements VueloService {
	
	@Autowired
	VueloDao dao;
	

	public VueloDao getDao() {
		return dao;
	}

	public void setDao(VueloDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Vuelo> getVuelos() {
		
		return dao.findVuelos();
		
	}

	@Override
	public Vuelo getVuelo(Integer id) {
		Vuelo miVuelo = dao.findVuelo(id);
		return miVuelo;
	}

	@Override
	public List<Vuelo> findVueloByDNI(int dni) {
		
		return dao.findVueloByDNI(dni);
	}
	
	

}
