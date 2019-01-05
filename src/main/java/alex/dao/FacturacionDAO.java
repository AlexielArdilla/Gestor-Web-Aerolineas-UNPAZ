package alex.dao;

import java.util.List;

import alex.entity.Facturacion;

public interface FacturacionDAO {
	
	List<Facturacion> getFacturaciones();
	
	int deleteFacturacionByID(int id);
	
	int createFacturacion(Facturacion facturacion);

}
