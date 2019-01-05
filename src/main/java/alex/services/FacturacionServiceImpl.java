package alex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.dao.FacturacionDAO;
import alex.entity.Facturacion;

@Service
public class FacturacionServiceImpl implements FacturacionService{

	@Autowired
	FacturacionDAO dao;
	
	@Override
	public List<Facturacion> getFacturaciones() {
		
		return dao.getFacturaciones();
	}

	@Override
	public int deleteFacturacionByID(int id) {
		
		return dao.deleteFacturacionByID(id);
	}

	@Override
	public int createFacturacion(Facturacion facturacion) {
		
		return dao.createFacturacion(facturacion);
	}

}
