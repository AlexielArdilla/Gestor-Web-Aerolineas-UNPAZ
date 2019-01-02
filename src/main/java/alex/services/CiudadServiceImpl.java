package alex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.dao.CiudadDao;
import alex.entity.Ciudad;

@Service
public class CiudadServiceImpl implements CiudadService{
	
	@Autowired
	CiudadDao dao;

	public CiudadDao getDao() {
		return dao;
	}

	public void setDao(CiudadDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Ciudad> getCiudades() {
		
		return dao.findCiudades();
		
	}

	@Override
	public Ciudad getCiudad(Integer id) {
		
		return dao.findCiudad(id);
	}
	
	
	
	

}
