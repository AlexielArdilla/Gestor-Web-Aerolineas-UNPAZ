package alex.dao;

import java.util.List;

import alex.entity.Avion;

public interface AvionDao {

	int create(Avion avion);

	List<Avion> findAviones();

	Avion findAvion(Integer id);
}
