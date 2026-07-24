package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import alex.databaseConnection.MyConnection;
import alex.entity.Ciudad;

@Repository
public class CiudadDaoImpl implements CiudadDao{

	@Override
	public List<Ciudad> findCiudades() {
		List <Ciudad> ciudades= new LinkedList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(
					"select ciudad.id, ciudad.nombre_ciudad from ciudad order by ciudad.id ASC");
					
			rs = ps.executeQuery();

			while (rs.next()) {

				Ciudad miCiudad = new Ciudad();
				miCiudad.setId(rs.getInt(1));
				miCiudad.setNombre_ciudad(rs.getString(2));
				
				ciudades.add(miCiudad);
				
			}
			
				
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}										
		}
						
		return ciudades;
	}

	@Override
	public Ciudad findCiudad(Integer id) {
		
		Ciudad miCiudad = new Ciudad();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(
					"select ciudad.id, ciudad.nombre_ciudad from ciudad where ciudad.id = "+id);
					
			rs = ps.executeQuery();

			while (rs.next()) {

				
				miCiudad.setId(rs.getInt(1));
				miCiudad.setNombre_ciudad(rs.getString(2));
				
			}
			
				
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}										
		}
						
		return miCiudad;
	}

}
