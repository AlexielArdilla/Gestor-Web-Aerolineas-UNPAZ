package alex.services;

import java.util.List;

import alex.entity.Avion;

public interface AvionService {

	int save(Avion avion);

	List<Avion> getAviones();

	Avion getAvion(Integer id);
}
