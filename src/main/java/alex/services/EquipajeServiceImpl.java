package alex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.dao.EquipajeDao;
import alex.entity.Equipaje;

@Service
public class EquipajeServiceImpl implements EquipajeService {

	@Autowired
	EquipajeDao dao;

	public EquipajeDao getDao() {
		return dao;
	}

	public void setDao(EquipajeDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Equipaje> getEquipajes() {
		return dao.findEquipajes();
	}

	@Override
	public Equipaje getEquipaje(Integer id) {
		
		return dao.findEquipaje(id);
	}

	@Override
	public int deleteById(int id) {
		
		return dao.deleteById(id);
	}
	
	
	
}
