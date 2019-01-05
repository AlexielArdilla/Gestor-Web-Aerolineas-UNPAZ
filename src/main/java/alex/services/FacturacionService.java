package alex.services;

import java.util.List;

import alex.entity.Facturacion;

public interface FacturacionService {
	
List<Facturacion> getFacturaciones();
	
	int deleteFacturacionByID(int id);

	int createFacturacion(Facturacion facturacion);
}
