package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import alex.databaseConnection.MyConnection;
import alex.entity.Facturacion;

@Repository
public class FacturacionDAOImpl implements FacturacionDAO{

	@Override
	public List<Facturacion> getFacturaciones() {
		
		List<Facturacion> misFacturaciones = new LinkedList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM facturacion";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Facturacion miFacturacion = new Facturacion();
				miFacturacion.setId(rs.getInt(1));
				miFacturacion.setNombre_yapel(rs.getString(2));
				miFacturacion.setDestino(rs.getString(3));
				miFacturacion.setCosto(rs.getInt(4));
				miFacturacion.setMedio_pago(rs.getString(5));
				miFacturacion.setNumero_tarjeta(rs.getString(6));
				miFacturacion.setNum_seguridad(7);
				
				misFacturaciones.add(miFacturacion);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return misFacturaciones;
	}

	@Override
	public int deleteFacturacionByID(int id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql ="DELETE FROM facturacion where id = ?";
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			r = ps.executeUpdate();
			
			if(r>0){
				
				System.out.println("Delete exitoso");
			}else{
				
				System.out.println("Algo falló");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return r;
	}

	@Override
	public int createFacturacion(Facturacion facturacion) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		String sql = "INSERT into facturacion values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, facturacion.getId());
			ps.setString(2, facturacion.getNombre_yapel());
			ps.setString(3, facturacion.getDestino());
			ps.setInt(4, facturacion.getCosto());
			ps.setString(5, facturacion.getMedio_pago());
			ps.setString(6, facturacion.getNumero_tarjeta());
			ps.setInt(7, facturacion.getNum_seguridad());
			
			r = ps.executeUpdate();
			
			if(r>0){
				
				System.out.println("Insert exitoso");
				
			}else{
				
				System.out.println("Algo fallo en el insert");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return r;
	}

}
