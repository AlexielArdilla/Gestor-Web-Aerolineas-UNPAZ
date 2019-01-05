package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import alex.databaseConnection.MyConnection;
import alex.entity.Vuelo;

@Repository
public class VueloDaoImpl implements VueloDao{

	Connection con = MyConnection.getConnection();
	
	@Override
	public List<Vuelo> findVuelos() {

		
		List <Vuelo> vuelos= new LinkedList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(
					"SELECT VUELO.ID, NOMBRE_COMPANIA, FECHA, A.NOMBRE_CIUDAD AS CIUDAD_ORIGEN, "+ 
			"B.NOMBRE_CIUDAD AS CIUDAD_DESTINO, DESCRIPCION AS AVION "+ "FROM VUELO INNER JOIN COMPANIA"+ 
							" ON VUELO.ID_COMPANIA = COMPANIA.ID INNER JOIN CIUDAD AS A "+
"ON VUELO.ID_CIUDAD_ORIGEN = A.ID "+
"LEFT JOIN CIUDAD AS B ON VUELO.ID_CIUDAD_DESTINO = B.ID LEFT JOIN AVION ON VUELO.ID_AVION = AVION.ID "
+ "order by vuelo.id ASC");
					
			rs = ps.executeQuery();

			while (rs.next()) {

				Vuelo miVuelo = new Vuelo();
				miVuelo.setId(rs.getInt(1));
				miVuelo.setNombre_compania(rs.getString(2));
				miVuelo.setFecha(rs.getDate(3));
				miVuelo.setCiudad_origen(rs.getString(4));
				miVuelo.setCiudad_destino(rs.getString(5));
				miVuelo.setAvion(rs.getString(6));
				
				vuelos.add(miVuelo);
				
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
						
		return vuelos;
		
	}

	@Override
	public Vuelo findVuelo(Integer id) {

		Vuelo miVuelo = new Vuelo();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			
			con = MyConnection.getConnection();
			ps = con.prepareStatement("SELECT VUELO.ID, NOMBRE_COMPANIA, FECHA, A.NOMBRE_CIUDAD AS CIUDAD_ORIGEN, "+ 
			"B.NOMBRE_CIUDAD AS CIUDAD_DESTINO, DESCRIPCION AS AVION "+ "FROM VUELO INNER JOIN COMPANIA"+ 
							" ON VUELO.ID_COMPANIA = COMPANIA.ID INNER JOIN CIUDAD AS A "+
"ON VUELO.ID_CIUDAD_ORIGEN = A.ID "+
"LEFT JOIN CIUDAD AS B ON VUELO.ID_CIUDAD_DESTINO = B.ID LEFT JOIN AVION ON VUELO.ID_AVION = AVION.ID "
+ "Where vuelo.id = "+id);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
			miVuelo.setId(id);
			miVuelo.setNombre_compania(rs.getString(2));
			miVuelo.setFecha(rs.getDate(3));
			miVuelo.setCiudad_origen(rs.getString(4));
			miVuelo.setCiudad_destino(rs.getString(5));
			miVuelo.setAvion(rs.getString(6));
			
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
						
		return miVuelo;
	}
	
	@Override
	public List<Vuelo> findVueloByDNI(int dni) {//Esta OK
		List <Vuelo> vuelos= new LinkedList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(
					"SELECT VUELO.ID as vuelo_ID, pasajero.nombre, FECHA, A.NOMBRE_CIUDAD "
					+ "AS CIUDAD_ORIGEN,B.NOMBRE_CIUDAD AS CIUDAD_DESTINO, DESCRIPCION AS AVION "
					+ "FROM VUELO INNER JOIN COMPANIA ON VUELO.ID_COMPANIA = COMPANIA.ID "
					+ "INNER JOIN CIUDAD AS A ON VUELO.ID_CIUDAD_ORIGEN = A.ID "
					+ "LEFT JOIN CIUDAD AS B ON VUELO.ID_CIUDAD_DESTINO = B.ID LEFT JOIN AVION ON VUELO.ID_AVION = AVION.ID "
					+ "INNER JOIN vuelo_pasajero ON vuelo.id = vuelo_pasajero.id_vuelo "
					+ "INNER JOIN pasajero ON vuelo_pasajero.id_pasajero = pasajero.id where pasajero.dni = "+dni+" "
					+ "order by vuelo.id ASC");
					
			rs = ps.executeQuery();

			while (rs.next()) {

				Vuelo miVuelo = new Vuelo();
				miVuelo.setId(rs.getInt(1));
				miVuelo.setNombre_compania(rs.getString(2));
				miVuelo.setFecha(rs.getDate(3));
				miVuelo.setCiudad_origen(rs.getString(4));
				miVuelo.setCiudad_destino(rs.getString(5));
				miVuelo.setAvion(rs.getString(6));
				
				vuelos.add(miVuelo);
				
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
						
		return vuelos;
	}
	
}
