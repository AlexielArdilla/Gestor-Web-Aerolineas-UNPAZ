package alex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import alex.dao.AvionDao;
import alex.entity.Avion;

@Service
public class AvionServiceImpl implements AvionService {

	@Autowired
	private AvionDao dao;

	public AvionDao getDao() {
		return dao;
	}

	public void setDao(AvionDao dao) {
		this.dao = dao;
	}

	@Override
	public int save(Avion avion) {

		return dao.create(avion);

	}

	@Override
	public List<Avion> getAviones() {
		
		return dao.findAviones();
	}

	@Override
	public Avion getAvion(Integer id) {
		
		return dao.findAvion(id);
	}

}
